package chmiel.problems;

import chmiel.utils.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kuba on 2015-03-01.
 */
public class Problem029 {
  private static final int A_MAX = 100;
  private static final int A_MIN = 2;
  private static final int B_MAX = 100;
  private static final int B_MIN = 2;

  public static void main(String[] args) {
    int[] primes = NumberUtils.setupPrimes(A_MAX + 1);
    ArrayList<int[]> distinctPowers = new ArrayList<int[]>();

    for (int a = A_MIN; a <= A_MAX; a++) {
      int[] primeExponentForm = NumberUtils.primeFactorization(a, primes);
      for (int b = B_MIN; b <= B_MAX; b++) {
        int[] power = NumberUtils.factorizedPow(primeExponentForm, b);

        //check if numbers already exists
        boolean doAdd = true;
        for (int i = 0; i < distinctPowers.size(); i++) {
          if (Arrays.equals(power, distinctPowers.get(i))) {
            doAdd = false;
            break;
          }
        }
        if (doAdd) {
          distinctPowers.add(power);
        }
      }
    }
//    for (int i = 0; i < distinctPowers.size(); i++) {
//      System.out.println(NumberUtils.factorizedGet(distinctPowers.get(i), primes));
//    }
//    System.out.println(distinctPowers);

    System.out.println("Nr of terms: " + distinctPowers.size());
  }
}
