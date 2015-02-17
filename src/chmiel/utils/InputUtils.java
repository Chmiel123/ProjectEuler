package chmiel.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by kuba on 17.02.15.
 */
public class InputUtils {

  public static Scanner getInputFile(String[] args) {
    if (args.length < 1) {
      System.out.println("Input file not specified.");
      System.exit(-1);
    }
    Scanner scan = null;
    try {
      scan = new Scanner(new File(args[0]));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.exit(-1);
    }
    return scan;
  }
}
