package chmiel.problems;

import chmiel.utils.NumberUtils;
import chmiel.utils.OutputUtils;

import java.util.ArrayList;

/**
 * Created by kuba on 08.03.15.
 */
public class Problem032 {

  private static final int MAX_MULTIPLIER = 10000;
  private static final int TARGET_DIGIT_NUM = 9;

  public static void main(String[] args) {
    long ts = System.nanoTime();

//    System.out.println(checkPandigital(39, 186)+" should be 7254);
    ArrayList<Integer> results = new ArrayList<Integer>();
    int resultSum = 0;
    for (int i = 1; i < MAX_MULTIPLIER; i++) {
      if (i % 1000000 == 0) {
        System.out.println((i / 1000000) + "mil");
      }
      int iDigitN = NumberUtils.getNumDigits(i);
      for (int j = i; j < MAX_MULTIPLIER; j++) {
        int jDigitN = NumberUtils.getNumDigits(j);
        if (iDigitN + jDigitN >= TARGET_DIGIT_NUM) {
          break;
        }
        int product = i * j;
        if (iDigitN + jDigitN + NumberUtils.getNumDigits(product) > TARGET_DIGIT_NUM) {
          break;
        }
        int res = checkPandigital(i, j);
        //check to see if its pandigital
        if (res > 0) {
          //check if product already added (2 entirely different multipliers)
          if (!results.contains(res)) {
            results.add(res);
            resultSum += res;
          }
        }
      }
    }

    long tf = System.nanoTime();
    System.out.println("      Results:");
    for (Integer res : results) {
      System.out.println(res);
    }
    System.out.println("Sum: " + resultSum);
    System.out.println("Time taken: " + OutputUtils.timeDiff(ts, tf) + "s");
  }


  private static int checkPandigital(int multiplicand, int multiplier) {
    int product = multiplicand*multiplier;
    int[] iDigits = NumberUtils.getDigits(multiplicand);
    int[] jDigits = NumberUtils.getDigits(multiplier);
    int[] productDigits = NumberUtils.getDigits(product);
    boolean[] digits = new boolean[10];
    for (int digit : iDigits) {
      if (digits[digit]) {
        return 0;
      } else {
        digits[digit] = true;
      }
    }
    for (int digit : jDigits) {
      if (digits[digit]) {
        return 0;
      } else {
        digits[digit] = true;
      }
    }
    for (int digit : productDigits) {
      if (digits[digit]) {
        return 0;
      } else {
        digits[digit] = true;
      }
    }
    for (int i = 1; i < digits.length; i++) {
      if (!digits[i]) {
        return 0;
      }
    }
    return product;
  }
}
