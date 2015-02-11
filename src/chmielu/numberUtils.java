package chmielu;

import java.math.BigInteger;

/**
 * Created by kuba on 10.02.15.
 */
public class numberUtils {
  /**
   * Counts the sum of digits of a given number.
   * @param number number.
   * @return sum of digits.
   */
  public static int countDigitSum(long number) {
    int sum = 0;
    while (number > 0) {
      sum += number % 10;
      number /= 10;
    }
    return sum;
  }/**
   * Counts the sum of digits of a given number.
   * @param number number.
   * @return sum of digits.
   */
  public static int countDigitSum(BigInteger number) {
    int sum = 0;
    while (number.compareTo(BigInteger.ZERO) > 0) {
      sum += (number.mod(BigInteger.TEN)).intValue();
      number = number.divide(BigInteger.TEN);
    }
    return sum;
  }
}
