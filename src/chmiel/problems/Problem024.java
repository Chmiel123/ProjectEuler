package chmiel.problems;

import chmiel.utils.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kuba on 17.02.15.
 */
public class Problem024 {
  public static final int TARGET = 1000000;


  public static void main(String[] args) {
    ArrayList<Long> permutations = new ArrayList<Long>();
    addIntPermutationsToArrayList(permutations);
    long[] perm = NumberUtils.ArrayListLongToArrayLong(permutations);
    System.out.println(perm.length);
    System.out.println(perm[TARGET - 1]);
    Arrays.sort(perm);
    System.out.println(perm[TARGET - 1]);
  }


  public static void addIntPermutationsToArrayList(ArrayList<Long> permutations) {
    int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    addIntPermutationsToArrayList(permutations, digits);
  }
  public static void addIntPermutationsToArrayList(ArrayList<Long> permutations, int[] digits) {
    addIntPermutationsToArrayList(permutations, digits, 0);
  }
  public static void addIntPermutationsToArrayList(ArrayList<Long> permutations, int[] digits, long builtNumber) {
    if (digits.length == 0) {
      permutations.add(builtNumber);
      return;
    }

    for (int i = 0; i < digits.length; i++) {
      int[] newDigits = new int[digits.length - 1];
      int index = 0;

      for (int j = 0; j < digits.length; j++) {
        if (i == j) {
          continue;
        }
        newDigits[index] = digits[j];
        index++;
      }
      long newBuiltNumber = builtNumber * 10 + digits[i];
      addIntPermutationsToArrayList(permutations, newDigits, newBuiltNumber);
    }
  }
}
