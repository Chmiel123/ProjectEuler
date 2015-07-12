package chmiel.Executor;

import chmiel.utils.InputUtils;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Kuba on 2015-07-02.
 */
public class Executor {
  private static final String PROBLEM_SPEC_FILENAME = "problemNumbers.txt";
  private static ProblemHandler p = new ProblemHandler();

  public static void main(String[] args) {
    Scanner scan = InputUtils.getInputFile(PROBLEM_SPEC_FILENAME);
    if (scan == null) {
      System.err.println("No file " + PROBLEM_SPEC_FILENAME + " found.");
      return;
    }

    while (scan.hasNextInt()) {
      int number = scan.nextInt();
      p.showProblemSolution(number);
    }
  }
}
