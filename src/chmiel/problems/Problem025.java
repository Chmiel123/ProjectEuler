package chmiel.problems;

import java.math.BigInteger;

/**
 * Created by kuba on 17.02.15.
 */
public class Problem025 {
  public static void main(String[] args) {
    BigInteger target = BigInteger.TEN.pow(1000 - 1);


    //iterative fibonacci
    int index = 2;
    BigInteger fibLast = BigInteger.ONE;
    BigInteger fibCurr = BigInteger.ONE;
    BigInteger swap;
    while (fibCurr.compareTo(target) < 0) {
      index++;
      swap = fibCurr;
      fibCurr = fibLast.add(fibCurr);
      fibLast = swap;
    }
    System.out.println(target);
    System.out.println(fibCurr);
    System.out.println("Answer: "+index);
  }
}
