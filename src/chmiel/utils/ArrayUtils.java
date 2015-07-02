package chmiel.utils;

import java.io.PrintStream;

/**
 * Created by Kuba on 2015-07-02.
 */
public class ArrayUtils {
  /**
   * Prints elements of an array to specified stream, using object.toString().
   * @param array array of elements to print out.
   * @param out stream to print to.
   * @param <T> class of elements in the array.
   */
  public static <T> void printArray(T[] array, PrintStream out) {
    for (int i = 0; i < array.length; i++) {
      out.print(array[i]+", ");
    }
  }

  /**
   * Checks if elements of an array make a palindrom, equality checked with o.equals(o).
   * @param array array of elements.
   * @param <T> class of elements.
   * @return wheter the elements form a palindrom.
   */
  public static <T> boolean isPalindrom(T[] array) {
    for (int i = 0; i <= array.length / 2; i++) {
      if (!array[i].equals(array[array.length - i - 1])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Converts an array of primitive type to boxed.
   * @param array array of elements of primitive type.
   * @return array of boxed elements.
   */
  public static Integer[] boxArray(int[] array) {
    Integer[] result = new Integer[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = array[i];
    }
    return result;
  }
}
