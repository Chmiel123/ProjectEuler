package chmiel.problems;

import chmiel.utils.OutputUtils;
import chmiel.utils.TimeMeasure;

import java.sql.Time;
import java.util.Arrays;

/**
 * Created by Kuba on 2015-03-05.
 */
public class Problem031 {

  public static final int TARGET = 200;
  private static int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
  private static long[] permutations = new long[TARGET + 1];

  private static long[][] cache = new long[TARGET+1][coins.length];
  static {
    for (long[] row : cache) {
      Arrays.fill(row, -1L);
    }
  }
  public static void main(String[] args) {
    System.out.println(coinPermutations(TARGET));
  }

  private static long coinPermutations(int cents) {
    return coinPermutations(cents, coins.length - 1);
  }
  private static long coinPermutations(int cents, int coinIndex) {
    if (cents == 0) {
      return 1;
    }
    if (coinIndex < 0) {
      return 0;
    }
    if (cents < 0) {
      return 0;
    }

    if (cache[cents][coinIndex] >= 0) {
      return cache[cents][coinIndex];
    }
    long permutations = 0;
    int coin = coins[coinIndex];
    int change = cents;

    while (change >= 0) {
      permutations += coinPermutations(change, coinIndex - 1);
      change -= coin;
    }
    if (permutations < 0) {
      System.exit(-1);
    }
    //permutations[cents] = permutations;
//    System.out.println(cents + ": " + permutations);
    cache[cents][coinIndex] = permutations;
    return permutations;
  }
}
