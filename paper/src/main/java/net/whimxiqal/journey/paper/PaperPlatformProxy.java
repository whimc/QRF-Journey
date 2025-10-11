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

import com.destroystokyo.paper.ParticleBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import net.kyori.adventure.key.Key;
import net.whimxiqal.journey.Cell;
import net.whimxiqal.journey.Color;
import net.whimxiqal.journey.InternalJourneyPlayer;
import net.whimxiqal.journey.JourneyPlayer;
import net.whimxiqal.journey.chunk.ChunkId;
import net.whimxiqal.journey.math.Vector;
import net.whimxiqal.journey.navigation.PlatformProxy;
import net.whimxiqal.journey.paper.chunk.PaperSessionJourneyBlock;
import net.whimxiqal.journey.paper.chunk.PaperSessionJourneyChunk;
import net.whimxiqal.journey.paper.gui.JourneyGui;
import net.whimxiqal.journey.paper.util.PaperUtil;
import net.whimxiqal.journey.proxy.JourneyBlock;
import net.whimxiqal.journey.proxy.JourneyChunk;
import net.whimxiqal.journey.proxy.UnavailableJourneyChunk;
import net.whimxiqal.journey.search.flag.FlagSet;
import net.whimxiqal.journey.util.BStatsUtil;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.CustomChart;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

public class PaperPlatformProxy implements PlatformProxy {

  private final BlockData animationBlockData = Material.WHITE_STAINED_GLASS.createBlockData();

  private final Metrics metrics;
  private List<String> cachedParticleTypeList;
  private Map<String, Particle> cachedParticleTypeMap;

  public PaperPlatformProxy() {
    metrics = new Metrics(JourneyPaper.get(), BStatsUtil.BSTATS_ID);
  }

  @Override
  public CompletableFuture<JourneyChunk> toChunk(ChunkId chunkId, boolean generate) {
    World world = PaperUtil.getWorld(chunkId.domain());
    return world.getChunkAtAsync(chunkId.x(), chunkId.z(), generate).thenApply(chunk -> {
      if (chunk == null) {
        return new UnavailableJourneyChunk(chunkId);
      } else {
        return new PaperSessionJourneyChunk(chunk.getChunkSnapshot(), world.getKey());
      }
    });
  }

  @Override
  public JourneyBlock toBlock(Cell cell) {
    return new PaperSessionJourneyBlock(cell, PaperUtil.getBlock(cell),
        PaperUtil.getBlock(cell.atOffset(0, -1, 0)), new FlagSet());
  }

  @Override
  public void spawnParticle(UUID playerUuid, String particleName, Color color, Key domain, double x, double y,
      double z) {
    Player player = Bukkit.getPlayer(playerUuid);
    World world = PaperUtil.getWorld(domain);
    if (player == null || !player.getWorld().equals(world)) {
      return;
    }
    ensureParticleTypeCache();
    Particle particle = cachedParticleTypeMap.get(particleName);
    if (particle == null) {
      return;
    }
    ParticleBuilder builder = particle.builder().receivers(player).location(world, x, y, z);
    if (particle == Particle.DUST) {
      builder.color(color.red(), color.green(), color.blue());
    }
    builder.spawn();
  }

  @Override
  public List<InternalJourneyPlayer> onlinePlayers() {
    return Bukkit.getOnlinePlayers().stream().map(PaperJourneyPlayer::new).collect(Collectors.toList());
  }

  @Override
  public Optional<InternalJourneyPlayer> onlinePlayer(UUID uuid) {
    return Optional.ofNullable(Bukkit.getPlayer(uuid)).map(PaperJourneyPlayer::new);
  }

  @Override
  public Optional<InternalJourneyPlayer> onlinePlayer(String name) {
    return Optional.ofNullable(Bukkit.getPlayer(name)).map(PaperJourneyPlayer::new);
  }

  @Override
  public Optional<Cell> entityCellLocation(UUID entityUuid) {
    return Optional.ofNullable(Bukkit.getEntity(entityUuid))
        .map(entity -> PaperUtil.toCell(entity.getLocation()));
  }

  @Override
  public Optional<Vector> entityVector(UUID entityUuid) {
    return Optional.ofNullable(Bukkit.getEntity(entityUuid))
        .map(entity -> PaperUtil.toLocalVector(entity.getLocation().toVector()));
  }

  @Override
  public void sendAnimationBlocks(UUID playerUuid, Collection<Cell> locations) {
    Player player = Bukkit.getPlayer(playerUuid);
    if (player == null) {
      return;
    }
    for (Cell location : locations) {
      if (PaperUtil.toCell(player.getLocation()).equals(location)
          || PaperUtil.toCell(player.getLocation().add(0, 1, 0)).equals(location)) {
        return;
      }
      showBlock(player, location, animationBlockData);
    }
  }

  @Override
  public void resetAnimationBlocks(UUID playerUuid, Collection<Cell> locations) {
    Player player = Bukkit.getPlayer(playerUuid);
    if (player == null) {
      return;
    }
    for (Cell cell : locations) {
      showBlock(player, cell, PaperUtil.getBlock(cell));
    }
  }

  private void showBlock(Player player, Cell cell, BlockData blockData) {
    if (PaperUtil.getWorld(cell.domain()) == player.getWorld() && cell
        .distanceToSquared(PaperUtil.toCell(player.getLocation())) < 10000 /* 100 blocks away, ignore */) {
      player.sendBlockChange(PaperUtil.toLocation(cell), blockData);
    }
  }

  @Override
  public boolean sendGui(JourneyPlayer player) {
    JourneyGui journeyGui = new JourneyGui(player);
    return journeyGui.open();
  }

  @Override
  public Consumer<CustomChart> bStatsChartConsumer() {
    return metrics::addCustomChart;
  }

  @Override
  public Map<Key, String> domains() {
    return Bukkit.getWorlds().stream()
        .collect(Collectors.toMap(world -> world.getKey(), world -> world.getName()));
  }

  @Override
  public List<String> particleTypes() {
    ensureParticleTypeCache();
    return cachedParticleTypeList;
  }

  @Override
  public boolean isValidParticleType(String particleType) {
    ensureParticleTypeCache();
    return cachedParticleTypeMap.containsKey(particleType.toLowerCase(Locale.ENGLISH));
  }

  private void ensureParticleTypeCache() {
    if (cachedParticleTypeList != null) {
      return;
    }
    List<String> particleNames = new ArrayList<>(Particle.values().length);
    cachedParticleTypeMap = new HashMap<>();
    for (Particle particle : Particle.values()) {
      String name = particle.name().toLowerCase(Locale.ENGLISH);
      particleNames.add(name);
      cachedParticleTypeMap.put(name, particle);
    }
    Collections.sort(particleNames);
    cachedParticleTypeList = Collections.unmodifiableList(particleNames);
  }

  @Override
  public boolean hasPermission(UUID uuid, String permission) {
    return Bukkit.getEntity(uuid).hasPermission(permission);
  }
}
