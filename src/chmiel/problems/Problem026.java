package chmiel.problems;

import java.util.ArrayList;

/**
 * Created by kuba on 21.02.15.
 */
public class Problem026 {
  private static final int TARGET = 1000;

  public static void main(String[] args) {
    int foundI = 1;
    int foundCycle = 0;

    int cycle;
    for (int i = 2; i < TARGET; i++) {
      cycle = lengthReciprocalCycle(1, i);
//      System.out.println(i+": "+cycle);
      if (cycle > foundCycle) {
        foundCycle = cycle;
        foundI = i;
      }

    }
//    System.out.println("1/"+foundI+" has a reciprocal cycle lenght of: "+foundCycle);
    System.out.println(foundI);
  }

  public static int lengthReciprocalCycle (int nominator, int denominator) {
    ArrayList<Integer> remainders = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();

    int index = 0;
    int foundIndex;
    while (nominator > 0) {
      remainders.add(nominator);
      result.add(nominator / denominator);
      nominator %= denominator;
      nominator *= 10;

      foundIndex = remainders.indexOf(nominator);
      if (foundIndex >= 0) {
        return index - foundIndex + 1;
      }
      index++;
    }
    return 0;

  }
}
