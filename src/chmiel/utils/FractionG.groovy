package chmiel.utils;

/**
 * Created by kuba on 31.03.15.
 */
public class FractionG {
  public static final FractionG ZERO = new FractionG(0,1);
  public static final FractionG ONE = new FractionG(1,1);

  public static final String DIVIDE_BY_ZERO_EXCEPTION_MESSAGE = "Fraction with 0 as denominator";

  private BigInteger nominator;
  private BigInteger denominator;

  public BigInteger getNominator() {
    return nominator;
  }

  public void setNominator(BigInteger nominator) {
    this.nominator = nominator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }

  public void setDenominator(BigInteger denominator) {
    this.denominator = denominator;
  }

  public BigDecimal getDecimal() {
    return ((BigDecimal)nominator)/denominator;
  }

//  public Fraction fromDecimal(double number) {
//
//  }

  public FractionG() {
    nominator = 0;
    denominator = 1;
  }
  public FractionG (BigInteger num, BigInteger den) {
    if (den == 0) {
      throw new ArithmeticException(DIVIDE_BY_ZERO_EXCEPTION_MESSAGE + ": " + num + "/" + den);
    }
    this.nominator = num;
    this.denominator = den;
    simplify();
  }

  public void simplify() {
    BigInteger multiplier = Numbers.gcd(nominator, denominator);
    nominator /= multiplier;
    denominator /= multiplier;
  }
  public FractionG reverse() {
    return new FractionG(denominator, nominator);
  }
  public FractionG opposite() {
    return new FractionG(-nominator, denominator);
  }


  public FractionG add(FractionG other) {
    BigInteger commonDenominator = denominator * other.denominator / Numbers.gcd(denominator, other.denominator);
    FractionG result = new FractionG();
    BigInteger thisNumMultiplier = commonDenominator / this.denominator;
    BigInteger otherNumMultiplier = commonDenominator / other.denominator;

    result.nominator = this.nominator * thisNumMultiplier + other.nominator * otherNumMultiplier;
    result.denominator = commonDenominator;
    result.simplify();
    return result;
  }
  public FractionG substract(FractionG other) {
    return add(other.opposite());
  }
  public FractionG multiply(FractionG other) {
    FractionG result = new FractionG();
    result.nominator = this.nominator * other.nominator;
    result.denominator = this.denominator * other.denominator;
    result.simplify();
    return result;
  }
  public FractionG divide(FractionG other) {
    return multiply(other.reverse());
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    FractionG fraction = (FractionG) o;

    return nominator * fraction.denominator == denominator * fraction.nominator;

  }

  @Override
  public String toString() {
    return nominator + "/" + denominator;
  }
}
