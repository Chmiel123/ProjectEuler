package chmiel.Problems;

import chmiel.utils.InputUtils;

import java.util.Scanner;

/**
 * Created by kuba on 05.02.15.
 *
 * Solution to ProjectEuler's Problem 11.
 */
public class Problem011 {
  private static final int xSize = 20;
  private static final int ySize = 20;
  private static final int PRODUCT_COUNT = 4;

  private static int maxValue = 0;

  public static void main(String[] args) {

    Scanner in = InputUtils.getInputFile(args);
    int[][] tab = new int[xSize][ySize];

//    System.out.println("Start.");
    //read 20x20 table of ints
    for (int i = 0; i < xSize; i++) {
      for (int j = 0; j < ySize; j++) {
        tab[i][j] = in.nextInt();
      }
    }
    //test if read correctly
    /*for (int i = 0; i < xSize; i++) {
      for (int j = 0; j < ySize; j++) {
        System.out.print(tab[i][j] + " ");
      }
      System.out.println();
    }*/
    //Iterate over rows and columns
    for (int i = 0; i < tab.length; i++) {
      iterateLine(tab, 0, i, 1, 0, PRODUCT_COUNT);
      iterateLine(tab, i, 0, 0, 1, PRODUCT_COUNT);
    }
    for (int i = 0; i < tab.length-PRODUCT_COUNT; i++) {
      iterateLine(tab, 0, i, 1, 1, PRODUCT_COUNT);
      iterateLine(tab, i, 0, 1, 1, PRODUCT_COUNT);
      iterateLine(tab, 0, tab.length-1-i, 1, -1, PRODUCT_COUNT);
      iterateLine(tab, i, tab.length-1, 1, -1, PRODUCT_COUNT);

    }
    System.out.println(maxValue);
//    System.out.println("Koniec.");
  }

  /**
   * checks for products of count consecutive numbers in a line given by starting points and "slope".
   * @param tab 2D array of integers.
   * @param xStart x start of the line.
   * @param yStart y start of the line.
   * @param dx x change in line on iteration.
   * @param dy y change in line on iteration.
   * @param count number of consecutive numbers in array to check product of.
   */
  private static void iterateLine(int[][] tab, int xStart, int yStart, int dx, int dy, int count) {
//    int testCount = 0;
    int product = 1;
    int number;
    for (int iInitial = 0; iInitial < count; iInitial++) {
      number = tab[xStart][yStart];
      if (number == 0) number = 1;
      product *= number;
      xStart += dx;
      yStart += dy;
    }
    checkMax(product);
//    testCount++;
    while (xStart < tab.length && xStart > -1 && yStart < tab[0].length && yStart > -1) {
      number = tab[xStart-count*dx][yStart-count*dy];
      if (number == 0) number = 1;
      product /= number;

      number = tab[xStart][yStart];
      if (number == 0) number = 1;
      product *= number;

      xStart += dx;
      yStart += dy;
      checkMax(product);
//      testCount++;
    }
//    System.out.println(testCount);
  }

  /**
   * Checks and saves if the given number is greater than already checked.
   * @param candidateForMax number to be checked.
   * @return wheter the number was greater.
   */
  private static boolean checkMax(int candidateForMax) {
    if (candidateForMax > maxValue) {
      maxValue = candidateForMax;
      return true;
    }
    return false;
  }
}
