package chmiel.utils;

/**
 * Created by kuba on 08.03.15.
 */
public class OutputUtils {

  /**
   * Converts two points in time of System.nanoTime() to period of time in seconds.
   * @param timeStart point in time returned by System.nanoTime()
   * @param timeFinish point in time returned by System.nanoTime()
   * @return length of time beetwen 2 points in seconds.
   */
  public static double timeDiff(long timeStart, long timeFinish) {
    if (timeFinish > timeStart) {
      return (timeFinish - timeStart) / 1000000000.0;
    }
    return (timeStart - timeFinish) / 1000000000.0;
  }
}
