package chmiel.problems;

import java.math.BigInteger;

/**
 * Created by kuba on 09.02.15.
 */
public class Problem016 {
  public static final int EXP = 1000;

  public static void main(String[] args) {
    BigInteger result = BigInteger.valueOf(2);
    result = result.pow(EXP);

    String st = result.toString();
    int sum = 0;
    char digit;
    for (int i = 0; i < st.length(); i++) {
      digit = st.charAt(i);
      sum += (int)digit - 48;
    }
    System.out.println("2^"+EXP+" =\n"+st+"\nSum of digits is "+sum);
  }
}
