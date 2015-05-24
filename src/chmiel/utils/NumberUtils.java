package chmiel.utils;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kuba on 10.02.15.
 */
public class NumberUtils {

  public static final String ERROR_TOO_FEW_PRIMES_COMPUTED = "ERROR: too few primes computed.";

  /**
   * Prints all array elements in one line.
   * @param array array to print elements of.
   * @param out printstream to print to.
   */
  public static void printArray(int[] array, PrintStream out) {
    for (int i = 0; i < array.length; i++) {
      out.print(array[i]+", ");
    }
  }

  /**
   * Get an array of decimal digits of a number.
   * @param number number.
   * @return array of digits.
   */
  public static int[] getDigits(int number) {
    ArrayList<Integer> digits = new ArrayList<Integer>();
    while (number > 0) {
      digits.add(number % 10);
      number /= 10;
    }
    return ArrayListIntegerToArrayInt(digits);
  }

  /**
   * Get the number of decimal digits of a number.
   * @param number number.
   * @return number of digits.
   */
  public static int getNumDigits(int number) {
    int result = 0;
    while (number > 0) {
      result++;
      number /= 10;
    }
    return result;
  }
  /**
   * Counts the sum of digits of a given number.
   * @param number number.
   * @return sum of digits.
   */
  public static int countDigitSum(long number) {
    int sum = 0;
    while (number > 0) {
      sum += number % 10;
      number /= 10;
    }
    return sum;
  }/**
   * Counts the sum of digits of a given number.
   * @param number number.
   * @return sum of digits.
   */
  public static int countDigitSum(BigInteger number) {
    int sum = 0;
    while (number.compareTo(BigInteger.ZERO) > 0) {
      sum += (number.mod(BigInteger.TEN)).intValue();
      number = number.divide(BigInteger.TEN);
    }
    return sum;
  }

  /**
   * Erastotenes sieve to find first primes less than N
   * @param N N.
   * @return array of primes.
   */
  public static int[] setupPrimes(int N) {
    int[] naturals = new int[N];
    int[] result;
    ArrayList<Integer> primes = new ArrayList<Integer>();

    for (int i = 0; i < naturals.length; i++) {
      naturals[i] = i;
    }
    int nthPrime = 2;
    for (int n = 0; true; n++) {
      for (int nthPrimeMultiple = nthPrime*nthPrime; nthPrimeMultiple < N && nthPrimeMultiple >= 0; nthPrimeMultiple+=nthPrime) {
        naturals[nthPrimeMultiple] = 0;
      }
      primes.add(n, nthPrime);

      do {
        nthPrime++;
        if (nthPrime >= naturals.length) {
          result = ArrayListIntegerToArrayInt(primes);
          return result;
        }
      } while (naturals[nthPrime] == 0);
    }
//    result = ArrayListIntegerToArrayInt(primes);
//    return result;
  }

  /**
   * Checks a pre computed prime table to see if tested number is a prime.
   * @param primes precomputed table of primes. See: setupPrimes().
   * @param testedNumber number to test is a prime.
   * @return wheter tested number is prime. False if there is not enough precomputed primes.
   */
  public static boolean isPrime(int[] primes, int testedNumber) {
    if (primes[primes.length - 1] < testedNumber) {
      System.err.println(ERROR_TOO_FEW_PRIMES_COMPUTED);
      return false;
    }
    return (Arrays.binarySearch(primes, testedNumber) >= 0);
  }

  /**
   * Utility method to turn an ArrayList of Integers to plain array of ints.
   * @param arrayList arrayList of Integers.
   * @return array of ints.
   */
  public static int[] ArrayListIntegerToArrayInt(ArrayList<Integer> arrayList) {
    int[] result = new int[arrayList.size()];
    for (int i = 0; i < arrayList.size(); i++) {
      result[i] = arrayList.get(i);
    }
    return result;
  }
  /**
   * Utility method to turn an ArrayList of Longs to plain array of longs.
   * @param arrayList arrayList of Longs.
   * @return array of longs.
   */
  public static long[] ArrayListLongToArrayLong(ArrayList<Long> arrayList) {
    long[] result = new long[arrayList.size()];
    for (int i = 0; i < arrayList.size(); i++) {
      result[i] = arrayList.get(i);
    }
    return result;
  }

  /**
   * Does prime factorization using prievously setup prime array.
   * @param number number to factorize.
   * @param primes array of precomputed primes. Largest prime <= sqrt(number).
   * @return array of exponents of each prime in primes.
   */
  public static int[] primeFactorization(int number, int[] primes) {
    int[] primesExponents = new int[primes.length];
    if (primes[primes.length-1]*primes[primes.length-1] < number) {
      System.err.println(ERROR_TOO_FEW_PRIMES_COMPUTED);
      return primesExponents;
    }
//    System.out.println("Number " + number + " =");
    //find exponents of prime factorization
    // n = p1^a * p2^b * p3^c * ...
    for (int n = 0; n < primes.length; n++) {
      while (number % primes[n] == 0) {
        primesExponents[n]++;
        number /= primes[n];
      }
      if (number < primes[n])
        break;
    }
    return primesExponents;
  }

  /**
   * Performs power operation on integer numbers in factorized form.
   * @param base base in factorized form. Use primeFactorization()
   * @param exponent exponent.
   * @return number in factorized form.
   */
  public static int[] factorizedPow(int[] base, int exponent) {
    int[] result = new int[base.length];
    for (int i = 0; i < base.length; i++) {
      result[i] = base[i] * exponent;
    }
    return result;
  }

  public static int factorizedGet(int[] number, int[] primes) {
    int result = 0;
    for (int i = 0; i < number.length; i++) {
      if (number[i] > 0) {
        result += Math.pow(primes[i], number[i]);
      }
    }
    return result;
  }
  /**
   * Finds all proper divisors and one.
   * @param number number to find divisors of.
   * @param primes array of precomputed primes.
   * @return array of divisors and one.
   */
  public static int[] findDivisorsByPrimeFactorization(int number, int[] primes) {
    int[] primesExponents = primeFactorization(number, primes);
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(1);

    for (int startingPrimeExponent = 0; startingPrimeExponent < primesExponents.length; startingPrimeExponent++) {

      if (primesExponents[startingPrimeExponent] > 0) {
//        divisor = primes[startingPrimeExponent];
        ArrayList<Integer> newResult = new ArrayList<Integer>();

        for (Integer included : result) {
          newResult.add(included);
          int divisor = 1;
          //plus
          for (int i = 1; i <= primesExponents[startingPrimeExponent]; i++) {
            divisor *= primes[startingPrimeExponent];
            int newDivisor = included * divisor;
            newResult.add(newDivisor);
          }
        }

        result = newResult;
      }
    }
    result.remove(result.size() - 1);
    return ArrayListIntegerToArrayInt(result);
  }

  /**
   * Performs power operation on integers.
   * @param base base.
   * @param exponent exponent.
   * @return result.
   */
  public static int pow(int base, int exponent) {
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    if (exponent % 2 == 0) {
      int result = pow(base, exponent / 2);
      return result * result;
    } else {
      int result = pow(base, exponent / 2);
      return result * result * base;
    }
  }
  /**
   * Sums all elements of an array
   * @param array array.
   * @return sum of elements of array.
   */
  public static int sumOfArrayElements(int[] array) {
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }

  /**
   * Finds greatest common divisor of numbers a and b.
   * @param a number.
   * @param b number.
   * @return greatest common divisor of both numbers.
   */
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a%b);
  }
}
