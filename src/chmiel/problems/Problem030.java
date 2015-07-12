package chmiel.problems;

import chmiel.utils.NumberUtils;

/**
 * Created by Kuba on 2015-03-01.
 */
public class Problem030 {

  public static final int TARGET = 400000;

  public static void main(String[] args) {
//    checkPowerFunctionTimes(1000000);
    int sum = 0;
    int exponent = 5;
    for (int i = 2; i < TARGET; i++) {
      int[] digits = NumberUtils.getDigits(i);
      for (int j = 0; j < digits.length; j++) {
        digits[j] = NumberUtils.pow(digits[j], exponent);
      }
      int digitsSum = NumberUtils.sumOfArrayElements(digits);
      if (digitsSum == i) {
        //System.out.println(i);
        sum += i;
      }
    }
    //System.out.println();
    System.out.println(sum);
  }

  /**
   * Compares time of execution of power funtions for integer values.
   * Compared functions are:
   * java.lang.Math.pow(double base, double exponent)
   * chmiel.utils.NumberUtils.pow(int base, int exponent)
   * @param times how many times should the experiment be conducted.
   */
  public static void checkPowerFunctionTimes(int times) {
    long timeStart = System.nanoTime();
    for (int i = -10; i < 10; i++) {
      for (int j = 0; j < 6; j++) {
        for (int k = 0; k < times; k++) {
          int result = (int)Math.pow(i, j);
        }
      }
    }

    long timeEnd = System.nanoTime();
    double mathPowTime = (timeEnd-timeStart) / 1000000000.0;

    timeStart = System.nanoTime();

    for (int i = -10; i < 10; i++) {
      for (int j = 0; j < 6; j++) {
        for (int k = 0; k < times; k++) {
          int result = NumberUtils.pow(i, j);
        }
      }
    }

    timeEnd = System.nanoTime();
    double myPowTime = (timeEnd-timeStart) / 1000000000.0;

    System.out.println("Math.pow(): " + mathPowTime + "s");
    System.out.println("NumberUtils.pow(): " + myPowTime + "s");
    System.out.println(mathPowTime / myPowTime + " times faster.");
  }
}
