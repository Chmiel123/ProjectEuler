package chmiel.problems;

import chmiel.utils.InputUtils;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kuba on 08.02.15.
 */
public class Problem013 {
  public static void main(String[] args) {
    Scanner scanner = InputUtils.getInputFile(args);
    BigInteger bInt, sum = BigInteger.valueOf(0);

    while (scanner.hasNextBigInteger()) {
      bInt = scanner.nextBigInteger();
//      System.out.println(bInt);
      sum = sum.add(bInt);
    }
    System.out.println(sum.toString().substring(0, 10));
    //System.out.println(sum);
  }
}
