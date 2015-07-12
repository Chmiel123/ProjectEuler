package chmiel.problems;

import chmiel.utils.NumberUtils;

import java.util.ArrayList;

/**
 * Created by kuba on 14.02.15.
 */
public class Problem023 {
  public static final int SMALLES_ABUNDANT_NUMBER = 12;
  private static final int TARGET = 28123;

  public static void main(String[] args) {
    int[] primes = NumberUtils.setupPrimes(TARGET);
    
    //find all abundant numbers less than TARGET
    ArrayList<Integer> abundants = new ArrayList<>();
    for (int n = SMALLES_ABUNDANT_NUMBER; n < TARGET; n++) {
      if (NumberUtils.sumOfArrayElements(NumberUtils.findDivisorsByPrimeFactorization(n, primes)) > n) {
        abundants.add(n);
      }
    }
    int[] abu = NumberUtils.ArrayListIntegerToArrayInt(abundants);
//    NumberUtils.printArray(abu, System.out);

    //find numbers that are not sums of 2 abundant numbers.
    int sum = 0;
    int lastN = 0;
    boolean[] isSumOfAbundantNumbers = new boolean[TARGET];
    for (int i = 1; i < isSumOfAbundantNumbers.length; i++) {
      isSumOfAbundantNumbers[i] = true;
    }
    for (int i = 0; i < abu.length; i++) {
      for (int j = i; j < abu.length; j++) {
        int checkedNumber = abu[i] + abu[j];
        if (checkedNumber < isSumOfAbundantNumbers.length) {
          isSumOfAbundantNumbers[checkedNumber] = false;
        }
      }
    }
    for (int i = 1; i < isSumOfAbundantNumbers.length; i++) {
      if (isSumOfAbundantNumbers[i]) {
        sum += i;
      }
    }
//    for (int n = 1; n <= TARGET; n++) {
//      if (!isSumOfTwoNumbers(n, abu)) {
//        sum += n;
//        lastN = n;
//      }
//    }
//    System.out.println("Biggest number: "+lastN);
    System.out.println(sum);
  }

  public static boolean isSumOfTwoNumbers(int n, int[] possibleSummands) {
    for (int i = 0; i < possibleSummands.length; i++) {
      for (int j = i; j < possibleSummands.length; j++) {
        if (possibleSummands[i] + possibleSummands[j] == n) {
          return true;
        }
      }
    }
    return false;
  }
}
