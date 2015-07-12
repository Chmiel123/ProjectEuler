package chmiel.utils;

import chmiel.utils.EngNotation.EngNotation;

/**
 * Created by Kuba on 2015-07-10.
 * Class measures time between 2 points in code.
 * As simple to use as possible.
 */
public class TimeMeasure {
  public static final int NANOSECONDS_IN_A_SECOND = 1_000_000_000;
  private static EngNotation notation = new EngNotation("s");

  private String measureName;
  private long startTime;
  private long elapsedTime = -1;

  public TimeMeasure() {
    measureName = "";
  }
  public TimeMeasure(String measureName) {
    this.measureName = measureName;
  }
  public void start() {
    startTime = System.nanoTime();
  }
  public void end() {
    long endTime = System.nanoTime();
    elapsedTime = endTime - startTime;
  }
  public double getElapsedTime() {
    return ((double)elapsedTime) / NANOSECONDS_IN_A_SECOND;
  }

  @Override
  public String toString() {
    if (measureName.equals("")) {
      return notation.get(getElapsedTime());
    }
    return measureName + ": " + notation.get(getElapsedTime());
  }
}
