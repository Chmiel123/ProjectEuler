package chmiel.utils

class TruncatingInteger {
  final BigInteger Number
  private long Precision
  
  TruncatingInteger (number, precision) {
    this.Number = number % precision
    this.Precision = precision
  }
  TruncatingInteger plus(other) {
    new TruncatingInteger(this.Number + other.Number, Precision)
  }
  TruncatingInteger multiply(other) {
    new TruncatingInteger(this.Number * other.Number, Precision)
  }
  TruncatingInteger power(TruncatingInteger exponent) {
    power((int)exponent.Number)
  }
  TruncatingInteger power(int exponent) {
    if (exponent == 0) {
      return new TruncatingInteger(1, Precision)
    }
    if (exponent == 1) {
      return this
    }
    def result
    if (exponent % 2 == 0) {
      result = power(exponent >> 1);
      return result * result;
    } else {
      result = power(exponent >> 1);
      return result * result * this;
    }
  }
  //UNTESTED
  Object asType(Class clazz) {
    if (clazz == Integer) {
      return number
    }
    else {
      super.asType(clazz)
    }
  }
  String toString() {
    return "...$Number"
  }
}