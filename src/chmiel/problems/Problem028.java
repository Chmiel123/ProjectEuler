package chmiel.problems;

/**
 * Created by Kuba on 2015-02-28.
 */
public class Problem028 {
  private static final int TARGET = 1001;

  public static void main(String[] args) {
    int n = 1;
    int result = 1;
    for (int i = 2; i < TARGET; i+=2) {
      result += 4*n + 10*i;
      n += 4*i;
    }
    System.out.println(result);
  }
}
