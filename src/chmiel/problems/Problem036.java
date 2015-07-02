package chmiel.problems;

import chmiel.utils.ArrayUtils;
import chmiel.utils.NumberUtils;

/**
 * Created by Kuba on 2015-07-02.
 */
public class Problem036 {
  public static final int TARGET_EXCLUSIVE = 1000000;
  
  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i < TARGET_EXCLUSIVE; i++) {
      Integer[] digits;

      digits = ArrayUtils.boxArray(NumberUtils.getDigits(i, 10));
      boolean palindromInBase10 = ArrayUtils.isPalindrom(digits);

      digits = ArrayUtils.boxArray(NumberUtils.getDigits(i, 2));
      boolean palindromInBase2 = ArrayUtils.isPalindrom(digits);

      if (palindromInBase10 && palindromInBase2) {
        sum += i;
      }
    }
    System.out.println(sum);

  }
}
