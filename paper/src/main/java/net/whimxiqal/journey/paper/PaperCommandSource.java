package net.whimxiqal.journey.paper;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import java.util.UUID;
import net.kyori.adventure.audience.Audience;
import net.whimxiqal.journey.command.CommandSource;
import org.bukkit.entity.Player;

public record PaperCommandSource(CommandSourceStack stack) implements CommandSource {

  @Override
  public Audience audience() {
    return stack.getSender();
  }

  @Override
  public UUID uuid() {
    if (stack.getExecutor() == null) {
      return null;
    }
    return stack.getExecutor().getUniqueId();
  }

  @Override
  public boolean allowed(String permission) {
    if (stack.getExecutor() == null) {
      return true;
    }
    return stack.getExecutor().hasPermission(permission);
  }

  @Override
  public Type type() {
    if (stack.getExecutor() != null && stack.getExecutor() instanceof Player) {
      return Type.PLAYER;
    } else {
      return Type.CONSOLE;
    }
  }

}
