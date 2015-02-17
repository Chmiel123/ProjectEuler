package chmiel.problems;

import chmiel.utils.NumberUtils;

import java.math.BigInteger;

/**
 * Created by kuba on 11.02.15.
 */
public class Problem020 {
  private static final int TARGET = 100;

  public static void main(String[] args) {
    BigInteger factorial = BigInteger.ONE;

    //simple iterative factorial with deleting following zeros.
    for (int i = 2; i <= TARGET; i++) {
      factorial = factorial.multiply(BigInteger.valueOf(i));
      while(factorial.mod(BigInteger.TEN).compareTo(BigInteger.ZERO) == 0) {
        factorial = factorial.divide(BigInteger.TEN);
      }
      //System.out.println(i+": "+factorial);
    }

    //count sum of digits
    System.out.println(NumberUtils.countDigitSum(factorial));
  }
}
