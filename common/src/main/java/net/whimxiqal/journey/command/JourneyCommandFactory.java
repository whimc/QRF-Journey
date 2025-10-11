package net.whimxiqal.journey.command;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import net.whimxiqal.journey.Cell;
import net.whimxiqal.journey.InternalJourneyPlayer;
import net.whimxiqal.journey.Journey;
import net.whimxiqal.journey.data.PersonalWaypointManager;
import net.whimxiqal.journey.message.Formatter;
import net.whimxiqal.journey.message.Messages;
import net.whimxiqal.journey.scope.ScopeUtil;
import net.whimxiqal.journey.scope.ScopedSessionResult;
import net.whimxiqal.journey.search.SearchSession;
import net.whimxiqal.journey.util.Permission;
import net.whimxiqal.journey.util.Validator;
import org.incendo.cloud.Command;
import org.incendo.cloud.CommandFactory;
import org.incendo.cloud.CommandManager;
import org.incendo.cloud.component.CommandComponent;
import org.incendo.cloud.context.CommandContext;
import org.incendo.cloud.context.CommandInput;
import org.incendo.cloud.key.CloudKey;
import org.incendo.cloud.parser.standard.BooleanParser;
import org.incendo.cloud.parser.standard.IntegerParser;
import org.incendo.cloud.parser.standard.StringParser;
import org.incendo.cloud.parser.standard.StringParser.StringMode;
import org.incendo.cloud.suggestion.Suggestion;
import org.incendo.cloud.suggestion.SuggestionProvider;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class JourneyCommandFactory<C> implements CommandFactory<C> {

  private final Function<C, ? extends CommandSource> senderConverter;
  private final Supplier<Collection<String>> onlineUsers;

  private final CloudKey<String> nameKey = CloudKey.cloudKey("name", String.class);
  private final CloudKey<Integer> pageKey = CloudKey.cloudKey("page", Integer.class);
  private final CloudKey<String> userKey = CloudKey.cloudKey("user", String.class);
  private final CloudKey<String> newNameKey = CloudKey.cloudKey("newname", String.class);
  private final CloudKey<Boolean> publicKey = CloudKey.cloudKey("public", Boolean.class);

  public JourneyCommandFactory(Function<C, ? extends CommandSource> senderConverter,
      Supplier<Collection<String>> onlineUsers) {
    this.senderConverter = senderConverter;
    this.onlineUsers = onlineUsers;
  }

  @Override
  public @NonNull List<@NonNull Command<? extends C>> createCommands(@NonNull CommandManager<C> manager) {
    List<Command<? extends C>> commands = new LinkedList<>();
    var journey = manager.commandBuilder("journey", "jo");
    commands.add(journey.handler(context -> {
      var sender = senderConverter.apply(context.sender());
      sender.audience().sendMessage(Formatter.welcome());
    }).build());

    {
      var journeySetWaypoint = journey.literal("setwaypoint")
          .argument(StringParser.stringComponent(StringMode.QUOTED).key(nameKey));
      commands.add(journeySetWaypoint.handler(this::journeySetWaypointHandler).build());

      var journeyListWaypoints = journey.literal("listwaypoints");
      // commands.add(journeyListWaypoints.handler(this::journeyListWaypointsHandler).build());

      var journeyListWaypointsMine = journeyListWaypoints.argument(pageComponent());
      commands.add(journeyListWaypointsMine.handler(this::journeyListWaypointsMineHandler).build());

      var journeyListWaypointsPlayer = journeyListWaypoints.literal("player")
          .argument(quotedStringComponent(nameKey));
      commands.add(journeyListWaypointsPlayer.handler(this::journeyListWaypointsPlayerHandler).build());

      var journeyWaypoint = journey.literal("waypoint").argument(quotedStringComponent(nameKey));
      commands.add(journeyWaypoint.handler(this::journeyWaypointHandler).build());

      {
        // TODO search flags

        var journeyWaypointUnset = journeyWaypoint.literal("unset");
        commands.add(journeyWaypointUnset.handler(this::journeyWaypointUnsetHandler).build());

        var journeyWaypointRename = journeyWaypoint.literal("rename")
            .argument(quotedStringComponent(newNameKey));
        commands.add(journeyWaypointRename.handler(this::journeyWaypointRenameHandler).build());

        var journeyWaypointPublic = journeyWaypoint.literal("public")
            .argument(BooleanParser.booleanComponent().key(publicKey).optional());
        commands.add(journeyWaypointPublic.handler(this::journeyWaypointPublicHandler).build());
      }

      var journeyPlayer = journey.literal("player").argument(userComponent());
      commands.add(journeyPlayer.handler(this::journeyPlayerHandler).build());

      {
        var journeyPlayerWaypoint = journeyPlayer.literal("waypoint")
            .argument(quotedStringComponent(nameKey));
        commands.add(journeyPlayerWaypoint.handler(this::journeyPlayerWaypointHandler).build());
      }

      var journeyServer = journey.literal("server");
      commands.add(journeyServer.handler(this::journeyServerHandler).build());

      {
        // TODO search flags

        var journeyServerSetWaypoint = journeyServer.literal("setwaypoint")
            .argument(quotedStringComponent(nameKey));
        commands.add(journeyServerSetWaypoint.handler(this::journeyServerSetWaypointHandler).build());

        var journeyServerListWaypoint = journeyServer.literal("listwaypoints");
        commands.add(journeyServerListWaypoint.handler(this::journeyServerListWaypointHandler).build());

        var journeyServerWaypoint = journeyServer.literal("waypoint");
        commands.add(journeyServerWaypoint.handler(this::journeyServerWaypointHandler).build());

        {
          var journeyServerWaypointUnset = journeyServerWaypoint.literal("unset");
          commands.add(journeyServerWaypointUnset.handler(this::journeyServerWaypointUnsetHandler).build());

          var journeyServerWaypointRename = journeyServerWaypoint.literal("rename");
          commands.add(journeyServerWaypointRename.handler(this::journeyServerWaypointRenameHandler).build());

        }
      }

      var journeyAdmin = journey.literal("admin");
      commands.add(journeyAdmin.handler(this::journeyAdminHandler).build());

      {
        var journeyAdminDebug = journeyAdmin.literal("debug");
        commands.add(journeyAdminDebug.handler(this::journeyAdminDebugHandler).build());
      }

      var journeyCancel = journey.literal("cancel");
      commands.add(journeyCancel.handler(this::journeyCancelHandler).build());
    }

    var navigate = manager.commandBuilder("navigate", "nav");
    // TODO search flags
    commands.add(navigate.handler(this::navigateHandler).build());

    {
      var navigateTarget = navigate.argument(StringParser.<C>stringComponent(StringMode.GREEDY_FLAG_YIELDING)
          .key(nameKey).suggestionProvider(this::navigateTargetSuggestions));
      commands.add(navigateTarget.handler(this::navigateTargetHandler).build());
    }
    return commands;
  }

  private CommandComponent<C> quotedStringComponent(CloudKey<String> key) {
    return StringParser.<C>stringComponent(StringMode.QUOTED).key(key).build();
  }

  private CommandComponent<C> pageComponent() {
    return CommandComponent.builder(pageKey, IntegerParser.<C>integerParser(0)).build();
  }

  private CommandComponent<C> userComponent() {
    return CommandComponent.builder(userKey, StringParser.<C>stringParser())
        .suggestionProvider(SuggestionProvider.blockingStrings((context, input) -> onlineUsers.get()))
        .build();
  }

  private boolean notAllowed(CommandSource src, @Nullable Permission permission, boolean onlyPlayer) {
    if (onlyPlayer && src.type() != CommandSource.Type.PLAYER) {
      Messages.COMMAND_ONLY_PLAYERS.sendTo(src.audience(), Formatter.ERROR);
      return true;
    }
    if (permission != null && !src.allowed(permission.path())) {
      Messages.COMMAND_NO_PERMISSION.sendTo(src.audience(), Formatter.ERROR);
      return true;
    }
    return false;
  }

  private void journeySetWaypointHandler(CommandContext<C> context) {
    var sender = senderConverter.apply(context.sender());
    String name = context.get(nameKey);
    if (Validator.isInvalidDataName(name)) {
      Messages.COMMAND_INVALID_INPUT.sendTo(sender.audience(), Formatter.ERROR, name);
      return;
    }

    Journey.get().proxy().schedulingManager().scheduleGlobalSync(() -> {
      Optional<Cell> location = Journey.get().proxy().platform().entityCellLocation(sender.uuid());
      if (location.isEmpty()) {
        // This should never happen
        return;
      }
      PersonalWaypointManager personalWaypointManager = Journey.get().proxy().dataManager()
          .personalWaypointManager();

      Journey.get().proxy().schedulingManager().scheduleAsync(() -> {
        Cell existingWaypoint = personalWaypointManager.getWaypoint(sender.uuid(), name);
        if (existingWaypoint != null) {
          Messages.COMMAND_WAYPOINT_PERSONAL_ALREADY_EXISTS.sendTo(sender.audience(), Formatter.ERROR, name);
          return;
        }

        personalWaypointManager.add(sender.uuid(), location.get(), name);
        Journey.get().cachedDataProvider().personalWaypointCache().update(sender.uuid(), true);
        Messages.COMMAND_WAYPOINT_PERSONAL_SET.sendTo(sender.audience(), Formatter.SUCCESS, name,
            Formatter.cell(location.get()));
      });
    });
  }

  private void journeyListWaypointsMineHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyListWaypointsPlayerHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyWaypointHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyWaypointUnsetHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyWaypointRenameHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyWaypointPublicHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyPlayerHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyPlayerWaypointHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyServerHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyServerSetWaypointHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyServerListWaypointHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyServerWaypointHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyServerWaypointUnsetHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyServerWaypointRenameHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyAdminHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyAdminDebugHandler(CommandContext<C> context) {
    // TODO
  }

  private void journeyCancelHandler(CommandContext<C> context) {
    // TODO
  }

  private void navigateHandler(CommandContext<C> context) {
    var sender = senderConverter.apply(context.sender());
    if (notAllowed(sender, Permission.PATH_GUI, true)) {
      return;
    }
    boolean sent = Journey.get().proxy().platform().sendGui(InternalJourneyPlayer.from(sender));
    if (!sent) {
      Messages.COMMAND_GUI_ERROR.sendTo(sender.audience(), Formatter.ERROR);
      return;
    }
  }

  private CompletableFuture<List<Suggestion>> navigateTargetSuggestions(CommandContext<C> context,
      CommandInput input) {
    var sender = senderConverter.apply(context.sender());
    var future = new CompletableFuture<List<Suggestion>>();
    Journey.get().proxy().schedulingManager().scheduleGlobalSync(() -> {
      future.complete(ScopeUtil.options(InternalJourneyPlayer.from(sender)).stream()
          .map(Suggestion::suggestion).toList());
    });
    return future;
  }

  private void navigateTargetHandler(CommandContext<C> context) {
    var sender = senderConverter.apply(context.sender());
    String targetString = context.get(nameKey);
    Journey.get().proxy().schedulingManager().scheduleGlobalSync(() -> {
      ScopedSessionResult scopedSessionResult = ScopeUtil.session(InternalJourneyPlayer.from(sender),
          targetString);
      switch (scopedSessionResult.type()) {
        case EXISTS:
          SearchSession session = scopedSessionResult.session().get();
          // session.addFlags(flags);
          Journey.get().searchManager().launchIngameSearch(session);
          break;
        case AMBIGUOUS:
          Messages.COMMAND_SCOPES_AMBIGUOUS.sendTo(sender.audience(), Formatter.ERROR, targetString,
              scopedSessionResult.ambiguousItem().get().scope1,
              scopedSessionResult.ambiguousItem().get().scope2);
          break;
        case NO_SCOPE:
          Messages.COMMAND_SCOPES_NO_SCOPE.sendTo(sender.audience(), Formatter.ERROR,
              scopedSessionResult.missing().get());
        case NONE:
          Messages.COMMAND_SCOPES_NONE.sendTo(sender.audience(), Formatter.ERROR, targetString);
          break;
        case NO_PERMISSION:
          Messages.COMMAND_NO_PERMISSION_VALUE.sendTo(sender.audience(), Formatter.ERROR, targetString);
          break;
      }
    });
  }

}
