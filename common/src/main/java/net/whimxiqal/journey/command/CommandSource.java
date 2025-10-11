package net.whimxiqal.journey.command;

import java.util.UUID;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.Nullable;

public interface CommandSource {

  Audience audience();

  @Nullable
  UUID uuid();

  boolean allowed(String permission);

  Type type();

  enum Type {
    PLAYER, CONSOLE
  }

}
