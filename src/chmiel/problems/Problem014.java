package chmiel.problems;

/**
 * Created by kuba on 08.02.15.
 */
public class Problem014 {
  private static final int TARGET = 1000000;

  public static long[] currentCollatzTermOfNumber = new long[TARGET];
  public static int[] chainLengthOfNumber = new int[TARGET];
  public static int nrOfStillGoingCollatzNumbers = TARGET - 2;
  private static int maxChain = 0;
  private static int startingNumberOfMaxChain = 0;
  private static long biggestNumberInAnySequence = 0;

  public static void main(String[] args) {
    //setup start numbers of a 1 000 000 or so collatz sequences.
    for (int i = 0; i < currentCollatzTermOfNumber.length; i++) {
      currentCollatzTermOfNumber[i] = i;
    }
    //until there is only one collatz sequence still advancing.
    while(nrOfStillGoingCollatzNumbers > 1) {
      //advance each collatz sequence by 1 iteration.
      for (int i = 2; i < chainLengthOfNumber.length; i++) {
        if (currentCollatzTermOfNumber[i] > 0) {
          currentCollatzTermOfNumber[i] = collatzFunction(currentCollatzTermOfNumber[i]);
          if (currentCollatzTermOfNumber[i] > biggestNumberInAnySequence) {
            biggestNumberInAnySequence = currentCollatzTermOfNumber[i];
          }
          chainLengthOfNumber[i]++;
          if (currentCollatzTermOfNumber[i] == 1) {
            currentCollatzTermOfNumber[i] = -1;
            nrOfStillGoingCollatzNumbers--;
          }
        }
      }
//      System.out.println(nrOfStillGoingCollatzNumbers);
//      System.out.println(biggestNumberInAnySequence);

    }
    for (int i = 0; i < currentCollatzTermOfNumber.length; i++) {
      if (chainLengthOfNumber[i] >= maxChain) {
        maxChain = chainLengthOfNumber[i];
        startingNumberOfMaxChain = i;
      }
    }
//    System.out.println("Starting number "+startingNumberOfMaxChain+" produces a chain of "+maxChain);
    System.out.println(startingNumberOfMaxChain);
  }

//  public static int collatzChain(long n) {
//    int chain = 1;
//    while (n != 1) {
//      chain++;
//      n = collatzFunction(n);
//    }
//    return chain;
//  }

  /**
   * n → n/2 (n is even)
   * n → 3n + 1 (n is odd)
   * @param n argument.
   * @return result.
   */
  public static long collatzFunction(long n) {
    if (n % 2 == 0) {
      return n/2;
    } else {
      return 3 * n + 1;
    }
  }
}
