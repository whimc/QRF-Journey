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

package net.whimxiqal.journey.paper;

import java.util.Arrays;
import java.util.stream.Collectors;
import net.kyori.adventure.audience.Audience;
import net.whimxiqal.journey.Journey;
import net.whimxiqal.journey.ProxyImpl;
import net.whimxiqal.journey.command.JourneyCommandFactory;
import net.whimxiqal.journey.config.Settings;
import net.whimxiqal.journey.paper.listener.DeathListener;
import net.whimxiqal.journey.paper.listener.PlayerListener;
import net.whimxiqal.journey.paper.listener.PluginDisableListener;
import net.whimxiqal.journey.paper.util.PaperLogger;
import net.whimxiqal.journey.paper.util.PaperSchedulingManager;
import net.whimxiqal.journey.util.Request;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.paper.PaperCommandManager;

public final class JourneyPaper extends JavaPlugin {

  private static JourneyPaper instance;

  public static JourneyPaper get() {
    return instance;
  }

  @Override
  public void onLoad() {
    instance = this;
  }

  @Override
  public void onEnable() {
    getLogger().info("Initializing Journey...");

    if (this.getDataFolder().mkdirs()) {
      getLogger().info("Journey data folder created");
    }

    Journey.create();
    // Set up Journey Proxy
    ProxyImpl proxy = new ProxyImpl();
    Journey.get().registerProxy(proxy);
    proxy.logger(new PaperLogger());
    proxy.dataFolder(this.getDataFolder().toPath());
    proxy.playerAudienceFunction(playerId -> {
      Player player = Bukkit.getPlayer(playerId);
      return player == null ? Audience.empty() : player;
    });
    proxy.consoleAudience(Bukkit.getConsoleSender());
    proxy.configPath(this.getDataFolder().toPath().resolve("config.yml"));
    proxy.messagesConfigPath(this.getDataFolder().toPath().resolve("messages.yml"));
    proxy.schedulingManager(new PaperSchedulingManager());
    proxy.platform(new PaperPlatformProxy());
    proxy.version(getPluginMeta().getVersion());

    // Initialize common Journey (after proxy is set up)
    boolean failed = false;
    try {
      if (!Journey.get().init()) {
        failed = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      failed = true;
    }

    if (failed) {
      Journey.logger().flush();
      Bukkit.getPluginManager().disablePlugin(this);
      return;
    }

    // Register command
    var commandManager = PaperCommandManager.builder()
        .executionCoordinator(ExecutionCoordinator.asyncCoordinator()).buildOnEnable(this);
    commandManager.command(new JourneyCommandFactory<>(PaperCommandSource::new,
        () -> Bukkit.getOnlinePlayers().stream().map(player -> player.getName()).toList()));

    Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
    Bukkit.getPluginManager().registerEvents(new PluginDisableListener(), this);

    if (Settings.EXTRA_CHECK_LATEST_VERSION_ON_STARTUP.getValue()) {
      Request.evaluateVersionAge("paper", getPluginMeta().getVersion());
    }
    if (Settings.EXTRA_FIND_INTEGRATIONS_ON_STARTUP.getValue()) {
      Request.checkForIntegrationPlugins("paper", Bukkit.getMinecraftVersion(), Arrays
          .stream(Bukkit.getPluginManager().getPlugins()).map(Plugin::getName).collect(Collectors.toSet()));
    }
  }

  @Override
  public void onDisable() {
    // Common Journey shutdown
    Journey.get().shutdown();
    Journey.remove();
  }
}
