package chmiel.utils.EngNotation;

/**
 * Created by Kuba on 2015-07-11.
 */
public class EngNotation {
  private static final String[] upperPrefixes = new String[] {"", "k", "M", "G", "T", "P", "E", "Z", "Y"};
  private static final String[] lowerPrefixes = new String[] {"", "m", "\u00B5", "n", "p", "f", "a", "z", "y"};

  private String unit;

  public EngNotation(String unit) {
    this.unit = unit;
  }
  public String get(double number) {
    int prefixIndex = 0;
    double multiplier = 1000;
    String selectedPrefix;
    if (number > 1.0) {
      while (number > multiplier) {
        prefixIndex++;
        number /= multiplier;
      }
      selectedPrefix = upperPrefixes[prefixIndex];
    } else {
      multiplier = 1.0/multiplier;
      while (number < 1.0) {
        prefixIndex++;
        number /= multiplier;
      }
      selectedPrefix = lowerPrefixes[prefixIndex];
    }
    return String.format("%.3f%s%s", number, selectedPrefix, unit);
  }
}
