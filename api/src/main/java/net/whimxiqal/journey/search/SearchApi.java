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

package net.whimxiqal.journey.search;

import java.util.UUID;
import java.util.concurrent.CompletionStage;
import net.whimxiqal.journey.Cell;
import net.whimxiqal.journey.JourneyAgent;
import net.whimxiqal.journey.Target;

/**
 * A sub-API to be used for managing searching within Journey.
 */
public interface SearchApi {

  /**
   * Execute a search from a given origin to a given destination for a given {@link JourneyAgent}.
   * Flags may be specified to alter the behavior of the search.
   *
   * @param agent       the agent
   * @param origin      the origin of the search
   * @param destination the destination of the search
   * @param flags       the flags to alter the behavior of the search
   * @return a completion stage with the result of the search, for callbacks
   */
  CompletionStage<SearchResult> runDestinationSearch(JourneyAgent agent, Cell origin, Target destination,
      SearchFlags flags);

  /**
   * Execute a search from a given origin to a given destination for a player with the given UUID.
   * The origin of the search will be the player's current location.
   * Flags may be specified to alter the behavior of the search.
   *
   * @param playerUuid  the uuid of the player
   * @param destination the destination of the search
   * @param flags       the flags to alter the behavior of the search
   * @return a completion stage with the result of the search, for callbacks
   */
  CompletionStage<SearchResult> runPlayerDestinationSearch(UUID playerUuid, Target destination,
      SearchFlags flags);

}
