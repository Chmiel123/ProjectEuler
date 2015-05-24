package chmiel.utils;

/**
 * Created by kuba on 31.03.15.
 */
public class Fraction {
  public static final Fraction ZERO = new Fraction(0,1);
  public static final Fraction ONE = new Fraction(1,1);

  public static final String DIVIDE_BY_ZERO_EXCEPTION_MESSAGE = "Fraction with 0 as denominator";

  private int nominator;
  private int denominator;

  public int getNominator() {
    return nominator;
  }

  public void setNominator(int nominator) {
    this.nominator = nominator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }

  public double getDecimal() {
    return ((double)nominator)/denominator;
  }

//  public Fraction fromDecimal(double number) {
//
//  }

  public Fraction() {
    nominator = 0;
    denominator = 1;
  }
  public Fraction (int num, int den) {
    if (den == 0) {
      throw new ArithmeticException(DIVIDE_BY_ZERO_EXCEPTION_MESSAGE + ": " + num + "/" + den);
    }
    this.nominator = num;
    this.denominator = den;
    simplify();
  }

  public void simplify() {
    int multiplier = NumberUtils.gcd(nominator, denominator);
    nominator /= multiplier;
    denominator /= multiplier;
  }
  public Fraction reverse() {
    return new Fraction(denominator, nominator);
  }
  public Fraction opposite() {
    return new Fraction(-nominator, denominator);
  }


  public Fraction add(Fraction other) {
    int commonDenominator = denominator * other.denominator / NumberUtils.gcd(denominator, other.denominator);
    Fraction result = new Fraction();
    int thisNumMultiplier = commonDenominator / this.denominator;
    int otherNumMultiplier = commonDenominator / other.denominator;

    result.nominator = this.nominator * thisNumMultiplier + other.nominator * otherNumMultiplier;
    result.denominator = commonDenominator;
    result.simplify();
    return result;
  }
  public Fraction substract(Fraction other) {
    return add(other.opposite());
  }
  public Fraction multiply(Fraction other) {
    Fraction result = new Fraction();
    result.nominator = this.nominator * other.nominator;
    result.denominator = this.denominator * other.denominator;
    result.simplify();
    return result;
  }
  public Fraction divide(Fraction other) {
    return multiply(other.reverse());
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Fraction fraction = (Fraction) o;

    return nominator * fraction.denominator == denominator * fraction.nominator;

  }

  @Override
  public String toString() {
    return nominator + "/" + denominator;
  }
}
