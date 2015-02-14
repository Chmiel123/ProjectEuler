package chmielu;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by kuba on 10.02.15.
 */
public class numberUtils {
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
      for (int nthPrimeMultiple = nthPrime*nthPrime; nthPrimeMultiple < N; nthPrimeMultiple+=nthPrime) {
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
   * Does prime factorization using prievously setup prime array.
   * @param number number to factorize.
   * @param primes array of precomputet primes. Largest prime <= sqrt(number).
   * @return array of exponents of each prime in primes.
   */
  public static int[] primeFactorization(int number, int[] primes) {
    int[] primesExponents = new int[primes.length];
    if (primes[primes.length-1]*primes[primes.length-1] < number) {
      System.out.println("ERROR: too few primes computed.");
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
}
