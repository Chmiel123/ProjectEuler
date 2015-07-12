package chmiel.Executor;

import chmiel.utils.TimeMeasure;
import com.sun.javafx.binding.StringFormatter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Kuba on 2015-07-02.
 */
public class ProblemHandler {
  public static final int MAX_PROBLEM_NUMBER = 200;
  private static final String PROBLEM_CLASS_NAME_PACKAGE = "chmiel.problems";
  private static final String PROBLEM_CLASS_NAME_PREFIX = "Problem";
  private Dictionary<Integer, Class> problems;

  private void getProblemClasses() {
    problems = new Hashtable<>();
    for (int i = 1; i <= MAX_PROBLEM_NUMBER; i++) {
      //build name of the class.
      String problemClassNameNumber = String.format("%03d", i);
      String problemClassFullName = PROBLEM_CLASS_NAME_PACKAGE + '.' + PROBLEM_CLASS_NAME_PREFIX + problemClassNameNumber;
      //get the class and check if exists
      try {
        Class c = Class.forName(problemClassFullName);
        problems.put(i, c);
      } catch (ClassNotFoundException ignored) {  }
    }
  }

  public static void main(String[] args) {
    ProblemHandler p = new ProblemHandler();

    TimeMeasure total = new TimeMeasure("total time");
    total.start();
    for (int nr : p.getProblemNumbers()) {
      p.showProblemSolution(nr);
    }
    total.end();
    System.out.println(total);
  }

  public ProblemHandler() {
    getProblemClasses();
  }

  public void showProblemSolution(int nr) {
    if (problems.get(nr) == null) {
      System.out.println("No problem " + nr + " found.");
    }
    System.out.println("============================================================================= PROBLEM: " + nr);

    TimeMeasure t = new TimeMeasure("time");
    t.start();

    this.executeProblem(nr);

    t.end();
    System.out.println(t);
  }
  public int[] getProblemNumbers() {
    int[] problemNumbers = new int[problems.size()];
    int i = 0;
    Enumeration<Integer> keys = problems.keys();
    while (keys.hasMoreElements()) {
      problemNumbers[i] = keys.nextElement();
      i++;
    }
    Arrays.sort(problemNumbers);
    return problemNumbers;
  }

  public void executeProblem(int problemNumber) {
    String[] args = new String[1];
    args[0] = "";
    try {
      Method main;
      //noinspection unchecked
      main = problems.get(problemNumber).getMethod("main", String[].class);
      String inputFileName = String.format("inputs/P_%03d.txt", problemNumber);
      args[0] = inputFileName;

      main.invoke(null, new Object[] {args});
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
