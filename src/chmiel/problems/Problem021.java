package chmiel.problems;

import chmiel.utils.NumberUtils;

/**
 * Created by kuba on 12.02.15.
 */
public class Problem021 {
  public static final int TARGET = 10000;

  public static void main(String[] args) {
    int[] primes = NumberUtils.setupPrimes(TARGET);
    int[] sumOfDivisors = new int[TARGET];
//    NumberUtils.printArray(primes, System.out);
//    System.out.println();

//    1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
//    int[] divisors = NumberUtils.findDivisorsByPrimeFactorization(220, primes);
//    NumberUtils.printArray(divisors, System.out);
//    System.out.println();
    int sumOfAmicableNumbers = 0;
    for (int number = 2; number < sumOfDivisors.length; number++) {
      //fill everything first.
      sumOfDivisors[number] = sumOfArrayElements(NumberUtils.findDivisorsByPrimeFactorization(number, primes));
    }
    for (int number = 2; number < sumOfDivisors.length; number++) {
      int nextIndex = sumOfDivisors[number];
      if (nextIndex < sumOfDivisors.length && number < nextIndex) {
        if (number == sumOfDivisors[nextIndex]) {
          //amicable numbers
          sumOfAmicableNumbers += number;
          sumOfAmicableNumbers += nextIndex;
        }
      } else  if (nextIndex >= sumOfDivisors.length) {
        //next number is greater than TARGET
        //System.out.println("too big: "+nextIndex);
        if (number == sumOfArrayElements(NumberUtils.findDivisorsByPrimeFactorization(nextIndex, primes))) {
          //amicable number
          sumOfAmicableNumbers += number;
        }
      }
    }
    System.out.println(sumOfAmicableNumbers);
  }

  private static int sumOfArrayElements(int[] array) {
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }
}
