package chmiel.Problems;

/**
 * Created by kuba on 09.02.15.
 */
public class Problem015 {
  public static final int GRID_SIZE = 20;

  public static void main(String[] args) {
    System.out.println("ABc");

    long[][] pathCost = new long[GRID_SIZE + 1][GRID_SIZE + 1];
    for (int i = 1; i < pathCost.length; i++) {
      pathCost[0][i] = 1;
      pathCost[i][0] = 1;
    }
    for (int i = 1; i < pathCost.length; i++) {
      for (int j = 1; j < pathCost.length; j++) {
        pathCost[i][j] = pathCost[i-1][j] + pathCost[i][j-1];
      }
    }
    System.out.println(arrayToString(pathCost));
  }

  public static String arrayToString(long[][] array) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        sb.append(array[i][j]);
        sb.append(", ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
