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

package net.whimxiqal.journey.paper.util;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.whimxiqal.journey.Cell;
import net.whimxiqal.journey.manager.SchedulingManager;
import net.whimxiqal.journey.paper.JourneyPaper;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class PaperSchedulingManager implements SchedulingManager {

  private class PaperCancelHandle implements CancelHandle {

    private ScheduledTask task;
    private boolean canceled;

    PaperCancelHandle(ScheduledTask task) {
      this.task = task;
      this.canceled = false;
    }

    synchronized void setInternal(@NotNull ScheduledTask task) {
      if (this.task != null) {
        throw new IllegalStateException("Task was already set");
      }
      this.task = task;
      if (canceled) {
        this.task.cancel();
      }
    }

    @Override
    public synchronized void cancel() {
      if (task != null) {
        task.cancel();
      }
      this.canceled = true;
    }

  }

  @Override
  public void scheduleAsync(Runnable runnable) {
    Bukkit.getAsyncScheduler().runNow(JourneyPaper.get(), task -> runnable.run());
  }

  @Override
  public void scheduleAsync(Runnable runnable, int tickDelay) {
    Bukkit.getAsyncScheduler().runDelayed(JourneyPaper.get(), task -> runnable.run(), tickDelay * 20,
        TimeUnit.MILLISECONDS);
  }

  @Override
  public void scheduleSync(Cell location, Runnable runnable) {
    Bukkit.getGlobalRegionScheduler().execute(JourneyPaper.get(), () -> {
      var world = Bukkit.getWorld(location.domain());
      Bukkit.getRegionScheduler().run(JourneyPaper.get(), world, location.chunkX(), location.chunkZ(),
          task -> runnable.run());
    });
  }

  @Override
  public void scheduleGlobalSync(Runnable runnable) {
    Bukkit.getGlobalRegionScheduler().execute(JourneyPaper.get(), runnable);
  }

  @Override
  public CancelHandle scheduleRepeatAsync(Runnable runnable, int tickPeriod) {
    return new PaperCancelHandle(Bukkit.getAsyncScheduler().runAtFixedRate(JourneyPaper.get(),
        task -> runnable.run(), 0, tickPeriod * 20, TimeUnit.MILLISECONDS));
  }

  @Override
  public CancelHandle scheduleRepeatGlobalSync(Runnable runnable, int tickPeriod) {
    return new PaperCancelHandle(Bukkit.getGlobalRegionScheduler().runAtFixedRate(JourneyPaper.get(),
        task -> runnable.run(), 1, tickPeriod));
  }

  @Override
  public CancelHandle scheduleRepeatEntity(UUID entityId, Runnable runnable, int tickPeriod) {
    var handle = new PaperCancelHandle(null);
    Bukkit.getGlobalRegionScheduler().execute(JourneyPaper.get(), () -> {
      var task = Bukkit.getEntity(entityId).getScheduler().runAtFixedRate(JourneyPaper.get(),
          t -> runnable.run(), () -> {
          }, 1, tickPeriod);
      handle.setInternal(task);
    });
    return handle;
  }

}
