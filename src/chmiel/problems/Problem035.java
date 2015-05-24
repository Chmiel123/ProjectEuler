package chmiel.problems;

import chmiel.utils.NumberUtils;

import java.util.Arrays;

/**
 * Created by kuba on 01.04.15.
 */
public class Problem035 {

  private static final int TARGET = 1000000;

  private static int[] primes;
  private static int[] circularAndPrime;

  public static void main(String[] args) {
    primes = NumberUtils.setupPrimes(TARGET);
    circularAndPrime = new int[TARGET];
    int sum = 0;

    for (int i = 2; i < circularAndPrime.length; i++) {
      //System.out.println(circularAndPrime[i]);
      int number = i;
      boolean areAllPrimes = true;
      do {
        if (!NumberUtils.isPrime(primes, number)) {
          areAllPrimes = false;
        }
        number = nextCircular(number);
      } while (number != i);
      if (areAllPrimes) {
        System.out.println(number);
        sum++;
      }
    }
    System.out.println("Sum: "+sum);
  }

  private static int nextCircular(int number) {
    int unitDigit = 0;
    int rotationSize = 0;
    while (unitDigit == 0) {
      rotationSize++;
      unitDigit = number % NumberUtils.pow(10, rotationSize);
    }
    int digits = NumberUtils.pow(10, log10(number) - rotationSize + 1);
    return unitDigit * digits + number / NumberUtils.pow(10, rotationSize);
  }

  private static final int[] logarithms = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
  private static int log10(int number) {
    if (number < 0) {
      return -1;
    }
    for (int i = 0; i < logarithms.length; i++) {
      if (number < logarithms[i]) {
        return i;
      }
    }
    return 9;
  }
}
