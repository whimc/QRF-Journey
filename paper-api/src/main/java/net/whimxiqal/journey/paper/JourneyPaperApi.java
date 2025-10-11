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

import java.util.ServiceLoader;
import net.whimxiqal.journey.Cell;
import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;

/**
 * The interface for Bukkit-specific external-facing endpoints for Journey.
 */
public interface JourneyPaperApi {

  /**
   * Get the Bukkit API instance.
   *
   * @return the Journey Bukkit API
   */
  static JourneyPaperApi get() {
    return JourneyPaperApi.Provider.INSTANCE;
  }

  /**
   * Convert a Bukkit {@link Location} to a {@link Cell}, which is just Journey's version of a location.
   *
   * @param location the location
   * @return the cell
   */
  Cell toCell(Location location);

  /**
   * Convert a {@link Cell} to a Bukkit {@link Location}.
   *
   * @param cell the cell
   * @return the location
   */
  Location toLocation(Cell cell);

  @ApiStatus.Internal
  final class Provider {

    private static final JourneyPaperApi INSTANCE = ServiceLoader
        .load(JourneyPaperApi.class, JourneyPaperApi.class.getClassLoader()).findFirst().orElseThrow();

    private Provider() {
    }
  }

}
