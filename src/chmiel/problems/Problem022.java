package chmiel.problems;

import chmiel.utils.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kuba on 14.02.15.
 */
public class Problem022 {

  public static void main(String[] args) {
    Scanner scan = InputUtils.getInputFile(args);

    int sum = 0;

    String in = scan.next();
//    System.out.println(in);
    String[] names = in.split("(\",\")|\"");
    Arrays.sort(names);
    for (int i = 0; i < names.length; i++) {
//      if (names[i].equals("COLIN")) {
//        System.out.println((i+1));
//      }
//      System.out.println(names[i]);
      sum += (i) * stringValue(names[i]);
    }
    System.out.println(sum);

  }

  private static int stringValue(String string) {
    int sum = 0;
    for (int i = 0; i < string.length(); i++) {
      sum += string.charAt(i) - 'A' + 1;
    }
    return sum;
  }
}
