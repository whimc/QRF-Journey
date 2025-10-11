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

package net.whimxiqal.journey;

import java.util.Objects;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.whimxiqal.journey.message.Formatter;
import org.jetbrains.annotations.Nullable;

public class CellTarget implements Target {

  private final Cell cell;

  public CellTarget(Cell cell) {
    this.cell = Objects.requireNonNull(cell);
  }

  @Override
  public @Nullable Cell get(Cell origin) {
    return cell;
  }

  @Override
  public boolean isSatisfiedBy(Cell location) {
    return cell.equals(location);
  }

  @Override
  public Key domain() {
    return cell.domain();
  }

  @Override
  public Component print() {
    return Formatter.cell(cell);
  }

  @Override
  public String toString() {
    return "CellTarget{" + "cell=" + cell + '}';
  }
}
