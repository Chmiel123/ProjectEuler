package chmiel.Executor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by Kuba on 2015-07-02.
 */
public class ProblemHandler {
  public static final int MAX_PROBLEM_NUMBER = 200;
  private static final String PROBLEM_CLASS_NAME_PACKAGE = "chmiel.problems";
  private static final String PROBLEM_CLASS_NAME_PREFIX = "Problem";
  private Dictionary<Integer, Class> problems;

  private void getProblemClasses() {
    problems = new Hashtable<Integer, Class>();
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
    for (int nr : p.getProblemNumbers()) {
      System.out.println("============================================================================= PROBLEM: " + nr);
      p.executeProblem(nr);
//      try {
//        System.in.read();
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
    }
  }

  public ProblemHandler() {
    getProblemClasses();
  }

  public int[] getProblemNumbers() {
    int[] problemNumbers = new int[problems.size()];
    int i = 0;
    Enumeration<Integer> keys = problems.keys();
    while (keys.hasMoreElements()) {
      problemNumbers[i] = keys.nextElement();
      i++;
    }
    return problemNumbers;
  }

  public void executeProblem(int problemNumber) {
    String[] args = new String[1];
    args[0] = "";
    try {
      Method main;
      //noinspection unchecked
      main = problems.get(problemNumber).getMethod("main", String[].class);
      main.invoke(null, new Object[] {args});
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
