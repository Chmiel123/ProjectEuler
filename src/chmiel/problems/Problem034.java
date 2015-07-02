package chmiel.problems;

import chmiel.utils.NumberUtils;

/**
 * Created by kuba on 31.03.15.
 */
public class Problem034 {
  public static void main(String[] args) {
    int number = 10;
    long sum = 0;

    //50 000 is enough
    //noinspection InfiniteLoopStatement
    while (number < 50000) {
      number++;
      long factorialSum = 0;
      int[] digits = NumberUtils.getDigits(number);
      for (int digit : digits) {
        factorialSum += (int) simpleFactorial(digit);
      }
      if (factorialSum == number) {
        sum += number;
        System.out.println("+" + number + " sum: " + sum);
      }
    }
  }

  public static long simpleFactorial (long n) {
    long product = 1;
    for (int i = 2; i <= n; i++) {
      product *= i;
    }
    return product;
  }
}
