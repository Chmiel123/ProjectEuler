package chmiel.problems;

import chmiel.utils.NumberUtils;

import java.util.Arrays;

/**
 * Created by Kuba on 2015-02-28.
 */
public class Problem027 {

  private static final int TARGET = 1000;
  private static int[] primes;

  public static void main(String[] args) {
    primes = NumberUtils.setupPrimes(TARGET * TARGET);
    Arrays.sort(primes);

    int maxLength = 0;
    int[] maxCoefs = new int[]{0,0,0};

    for (int a = -TARGET + 1; a < TARGET; a++) {
      for (int b = -TARGET + 1; b < TARGET; b++) {
        int[] coefs = new int[]{b, a, 1};
        int length = lengthPrimeSeriesFromQuadratic(coefs);
        if (length > maxLength) {
          maxLength = length;
          maxCoefs = coefs;
        }
      }
    }
    //System.out.println("Polynomial: x^2 + " + maxCoefs[1] + "x + " + maxCoefs[0]);
    //System.out.println("produces a chain of primes of length: "+maxLength);
    System.out.println((maxCoefs[0] * maxCoefs[1]));
  }


  public static int lengthPrimeSeriesFromQuadratic(int[] coefficients) {
    int i = 0;
    while (true) {
      int polyResult = polyVal(coefficients, i);
      if (Arrays.binarySearch(primes, polyResult) < 0) {
        return i;
      }
      i++;
    }
  }

  public static int polyVal(int[] coefficients, int arg) {
    int result = 0;
    int poweredArg = 1;
    for (int i = 0; i < coefficients.length; i++) {
      result += coefficients[i] * poweredArg;
      poweredArg *= arg;
    }
    return result;
  }
}
