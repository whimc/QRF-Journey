/*
 * MIT License
 *
 * Copyright (c) whimxiqal
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.whimxiqal.journey.command;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import net.whimxiqal.journey.Cell;
import net.whimxiqal.journey.Destination;
import net.whimxiqal.journey.Journey;
import net.whimxiqal.journey.JourneyApi;
import net.whimxiqal.journey.JourneyTestHarness;
import net.whimxiqal.journey.Scope;
import net.whimxiqal.journey.VirtualMap;
import net.whimxiqal.journey.manager.TestSchedulingManager;
import net.whimxiqal.journey.platform.TestJourneyPlayer;
import net.whimxiqal.journey.platform.TestPlatformProxy;
import net.whimxiqal.journey.platform.WorldLoader;
import org.incendo.cloud.CommandManager;
import org.incendo.cloud.execution.CommandResult;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.internal.CommandRegistrationHandler;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestCommands extends JourneyTestHarness {

  record TestCommandSender(Audience audience, UUID uuid, CommandSource.Type type, Set<String> disallowed)
      implements CommandSource {

    @Override
    public boolean allowed(String permission) {
      return !disallowed.contains(permission);
    }

  }

  class TestCommandManager extends CommandManager<TestCommandSender> {

    public TestCommandManager() {
      super(ExecutionCoordinator.simpleCoordinator(),
          CommandRegistrationHandler.nullCommandRegistrationHandler());
    }

    @Override
    public final boolean hasPermission(final @NonNull TestCommandSender sender,
        final @NonNull String permission) {
      return !permission.equalsIgnoreCase("no");
    }
  }

  private TestCommandManager manager;

  @BeforeEach
  void init() {
    manager = new TestCommandManager();
    manager
        .command(new JourneyCommandFactory<TestCommandSender>(Function.identity(), () -> List.of("Notch")));
  }

  List<String> completions(String command) {
    return manager.suggestionFactory()
        .suggestImmediately(new TestCommandSender(Journey.get().proxy().consoleAudience(), PLAYER_UUID,
            CommandSource.Type.PLAYER, Set.of()), command)
        .list().stream().map(sugg -> sugg.suggestion()).toList();
  }

  static void addHome() throws ExecutionException, InterruptedException {
    if (Journey.get().proxy().dataManager().personalWaypointManager().getWaypoint(PLAYER_UUID,
        "home") != null) {
      // already has it
      return;
    }
    Journey.get().proxy().dataManager().personalWaypointManager().add(PLAYER_UUID,
        new Cell(0, 0, 0, Key.key("0")), "home");
    Journey.get().cachedDataProvider().personalWaypointCache().update(PLAYER_UUID, true).get();
  }

  static void grantAllPermissions(UUID player) {
    ((TestPlatformProxy) Journey.get().proxy().platform()).grantAllPermissions(player);
  }

  static void revokeAllPermissions(UUID player) {
    ((TestPlatformProxy) Journey.get().proxy().platform()).revokeAllPermissions(player);
  }

  private CommandResult<TestCommandSender> execute(String command) {
    return TestSchedulingManager.supplyAsync(() -> manager.commandExecutor()
        .executeCommand(new TestCommandSender(Journey.get().proxy().consoleAudience(), PLAYER_UUID,
            CommandSource.Type.PLAYER, Set.of()), command))
        .join();
  }

  void commandSuccess(String command) throws ExecutionException, InterruptedException {
    Assertions.assertNotNull(execute(command), "\"Test failed for command " + command + "\"");
  }

  void commandFailure(String command) throws ExecutionException, InterruptedException {
    Assertions.assertNull(execute(command), "\"Test failed for command " + command + "\"");
  }

  @Test
  void sampleTest() throws ExecutionException, InterruptedException {
    commandSuccess("journey");
  }

  @Disabled("JourneyTo is not yet implemented")
  @Test
  void journeyToTest() throws ExecutionException, InterruptedException {
    addHome();
    commandSuccess("journeyto home");
    commandSuccess("journeyto personal:home");
    Journey.get().proxy().dataManager().publicWaypointManager().add(new Cell(0, 0, 0, Key.key("0")), "home");
    commandSuccess("journeyto home"); // should result in failure message to user because "home" is ambiguous now
    commandSuccess("journeyto personal:home");
    commandSuccess("journeyto server:home");

    commandSuccess("journeyto surface");
    commandFailure("journeyto world:" + WorldLoader.worldResources[0]); // we are already in world 0
    Cell originalLocation = TestJourneyPlayer.LOCATION;
    TestJourneyPlayer.LOCATION = new Cell(0, 0, 0, Key.key("1"));
    commandSuccess("journeyto world:" + WorldLoader.worldResources[0]);
    TestJourneyPlayer.LOCATION = originalLocation;
    commandSuccess("journeyto world:" + WorldLoader.worldResources[1]);

    commandSuccess("journeyto death"); // should result in failure message to user because there are no deaths yet
    Journey.get().playerManager().setDeathLocation(PLAYER_UUID, new Cell(0, 0, 0, Key.key("0")));
    commandSuccess("journeyto death");

    revokeAllPermissions(PLAYER_UUID);
    commandFailure("journeyto home");
  }

  @Disabled("JourneyTo is not yet implemented")
  @Test
  void journeyToCompletionsTest() throws ExecutionException, InterruptedException {
    addHome();
    TestSchedulingManager.runAsync(() -> {
      List<String> completions = completions("journeyto personal:");
      Assertions.assertEquals(1, completions.size());
      Assertions.assertEquals("personal:home", completions.get(0));
    });
  }

  @Disabled("JourneyTo is not yet implemented")
  @Test
  void complicatedScope() throws ExecutionException, InterruptedException {
    JourneyApi api = JourneyApi.get();
    Destination destination = Destination.of(new Cell(0, 0, 0, Key.key("0")));
    revokeAllPermissions(PLAYER_UUID);
    final List<String> completions = new LinkedList<>();
    TestSchedulingManager.runAsync(() -> {
      api.registerScope("Journey", "complex", Scope.builder().subScopes(() -> {
        Map<String, Scope> scopes = new HashMap<>();
        scopes.put("path-a", Scope.builder().destinations(() -> {
          Map<String, Destination> destinations = new HashMap<>();
          destinations.put("path-a-1", destination);
          destinations.put("path-shared", destination);
          destinations.put("permission", Destination.cellBuilder(new Cell(0, 0, 0, Key.key("0")))
              .permission("you-dont-have-this").build());
          return VirtualMap.of(destinations);
        }).build());
        scopes.put("path-b", Scope.builder().destinations(() -> {
          Map<String, Destination> destinations = new HashMap<>();
          destinations.put("path-b", destination);
          destinations.put("path-b-1", destination);
          destinations.put("path-b space", destination);
          destinations.put("path-shared", destination);
          return VirtualMap.of(destinations);
        }).build());
        scopes.put("contextually-necessary", Scope.builder().destinations(() -> {
          Map<String, Destination> destinations = new HashMap<>();
          destinations.put("path-a-1", destination);
          destinations.put("hidden", destination);
          return VirtualMap.of(destinations);
        }).strict().build());
        scopes.put("permission-scope",
            Scope.builder().destinations(VirtualMap.ofSingleton("cant-reach", destination))
                .permission("you-also-dont-have-this").build());
        return VirtualMap.of(scopes);
      }).build());
      completions.addAll(completions("journeyto "));
    });

    // Full scope
    Assertions.assertTrue(completions.contains("complex:path-a:path-a-1"));
    Assertions.assertTrue(completions.contains("complex:path-a:path-shared"));
    Assertions.assertTrue(completions.contains("complex:path-b:path-b-1"));
    Assertions.assertTrue(completions.contains("complex:path-b:path-shared"));

    // Partial scope (skip highest level)
    Assertions.assertTrue(completions.contains("path-a:path-a-1"));
    Assertions.assertTrue(completions.contains("path-b:path-b-1"));

    // Partial scope (skip highest and second level)
    Assertions.assertTrue(completions.contains("path-a-1"));
    Assertions.assertTrue(completions.contains("path-b-1"));
    Assertions.assertTrue(completions.contains("\"path-b space\""));

    // Merge names if scope and its destination has the same one
    Assertions.assertTrue(completions.contains("complex:path-b"));
    Assertions.assertFalse(completions.contains("complex:path-b:path-b"));

    // Quotes around things with spaces
    Assertions.assertTrue(completions.contains("\"complex:path-b:path-b space\""));

    // Ambiguous
    Assertions.assertFalse(completions.contains("path-shared"));

    // Contextually specific things don't get in the way of other destinations
    Assertions.assertTrue(completions.contains("contextually-necessary:path-a-1"));
    Assertions.assertTrue(completions.contains("contextually-necessary:hidden"));
    Assertions.assertFalse(completions.contains("hidden"));

    // No Permission
    String[] permissionRequired = { "path-a:permission", "permission", "permission-scope:cant-reach",
        "cant-reach" };
    for (String string : permissionRequired) {
      Assertions.assertFalse(completions.contains(string), "The scope target " + string
          + " should be disallowed by permission restriction, but isn't disallowed");
    }
    grantAllPermissions(PLAYER_UUID);
    TestSchedulingManager.runAsync(() -> {
      completions.clear();
      completions.addAll(completions("journeyto "));
    });
    for (String string : permissionRequired) {
      Assertions.assertTrue(completions.contains(string));
    }

    // path-a-1
    commandSuccess("journeyto complex:path-a:path-a-1");
    commandSuccess("journeyto path-a:path-a-1");
    commandSuccess("journeyto complex:path-a-1");
    commandSuccess("journeyto path-a-1"); // still good, even though contextually-necessary also has it

    // path-shared in path-a scope
    commandSuccess("journeyto complex:path-a:path-shared");
    commandSuccess("journeyto path-a:path-shared");
    commandFailure("journeyto complex:path-shared"); // ambiguous with scope path-b
    commandFailure("journeyto path-shared"); // ambiguous with scope path-b

    // path-b
    commandSuccess("journeyto complex:path-b");
    commandSuccess("journeyto complex:path-b:path-b"); // redundant, but ok
    commandSuccess("journeyto path-b"); // redundant, but ok

    // path-b-1
    commandSuccess("journeyto complex:path-b:path-b-1");
    commandSuccess("journeyto path-b:path-b-1");
    commandSuccess("journeyto complex:path-b-1");
    commandSuccess("journeyto path-b-1");

    // path-b space
    commandSuccess("journeyto \"complex:path-b:path-b space\"");
    commandSuccess("journeyto \"path-b:path-b space\"");
    commandSuccess("journeyto \"complex:path-b space\"");
    commandSuccess("journeyto \"path-b space\"");

    // path-shared in path-b scope
    commandSuccess("journeyto complex:path-b:path-shared");
    commandSuccess("journeyto path-b:path-shared");

    // path-a-1 in contextually-necessary scope
    commandSuccess("journeyto contextually-necessary:path-a-1");

    // hidden
    commandSuccess("journeyto contextually-necessary:hidden");
    commandFailure("journeyto hidden");

    // no permission
    revokeAllPermissions(PLAYER_UUID);
    for (String string : permissionRequired) {
      commandFailure("journeyto " + string);
    }
    grantAllPermissions(PLAYER_UUID);
    for (String string : permissionRequired) {
      commandSuccess("journeyto " + string);
    }
  }
}
