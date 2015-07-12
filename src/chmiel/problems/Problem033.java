package chmiel.problems;

import chmiel.utils.Fraction;
import chmiel.utils.NumberUtils;

/**
 * Created by kuba on 31.03.15.
 */
public class Problem033 {
  public static void main(String[] args) {
//    Fraction a = new Fraction(4, 6);
//    Fraction b = new Fraction(1, 2);
//    System.out.println(a + " " + b);
//    System.out.println("+ " + a.add(b));
//    System.out.println("- " + a.substract(b));
//    System.out.println("* " + a.multiply(b));
//    System.out.println("/ " + a.divide(b));

    Fraction product = new Fraction(1,1);

    for (int denom = 10; denom < 100; denom++) {
      for (int nom = 10; nom < denom; nom++) {
        int[] dDen = NumberUtils.getDigits(denom);
        int[] dNom = NumberUtils.getDigits(nom);
        Fraction badSimplified;
        if (dNom[0] == 0 || dNom[1] == 0 || dDen[0] == 0 || dDen[1] == 0) {
          continue;
        }
        if (dNom[0] == dDen[0]) {
          badSimplified = new Fraction(dNom[1], dDen[1]);
        } else if (dNom[1] == dDen[0]) {
          badSimplified = new Fraction(dNom[0], dDen[1]);
        } else if (dNom[0] == dDen[1]) {
          badSimplified = new Fraction(dNom[1], dDen[0]);
        } else if (dNom[1] == dDen[1]) {
          badSimplified = new Fraction(dNom[0], dDen[0]);
        } else {
          continue;
        }
        Fraction realSimplified = new Fraction(nom, denom);
        if (realSimplified.equals(badSimplified)) {
          //System.out.println(realSimplified + " -> " + badSimplified);
          product = product.multiply(realSimplified);
        }

      }
    }
    System.out.println(product.getDenominator());
  }
}
