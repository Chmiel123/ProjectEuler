package chmiel.problems;

import chmiel.utils.InputUtils;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by kuba on 11.02.15.
 */
public class Problem018 {

  private static Vector<Vector<Integer>> rows = new Vector<Vector<Integer>>();

  public static void main(String[] args) {
    //read input triangle
    Scanner sc = InputUtils.getInputFile(args);
    int rowNr = 1;
    while(sc.hasNextInt()) {
      Vector<Integer> currentRow = new Vector<Integer>();
      for (int i = 0; i < rowNr; i++) {
        currentRow.add(sc.nextInt());
      }
      rows.add(currentRow);
      rowNr++;
    }
    //test write input
//    for (Vector<Integer> row : rows) {
//      for (Integer i : row) {
//        System.out.print(i+" ");
//      }
//      System.out.println();
//    }

    //solve
    for (int i = rows.size()-2; i >= 0; i--) {
      for (int j = 0; j < rows.get(i).size(); j++) {
        int leftPathCost = rows.get(i).get(j) + rows.get(i+1).get(j);
        int rightPathCost = rows.get(i).get(j) + rows.get(i+1).get(j+1);
        if (leftPathCost > rightPathCost) {
          rows.get(i).set(j, leftPathCost);
        } else {
          rows.get(i).set(j, rightPathCost);
        }
      }
    }

    //get result
    System.out.println(rows.get(0).get(0));
  }
}
