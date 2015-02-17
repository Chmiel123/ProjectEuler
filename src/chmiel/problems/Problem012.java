package chmiel.problems;

/**
 * Created by kuba on 06.02.15.
 *
 * Solution to ProjectEuler's Problem 12.
 */
public class Problem012 {
  public static final int TARGET_NR_DIVISORS = 500;
  public static final int NR_PRIMES = 500;
  public static final int BIGGEST_PRIME = 3572;

  public static int[] primes = new int[NR_PRIMES];



  public static void main(String[] args) {
    setupPrimes();
//    for (int i = 0; i < primes.length; i++) {
//      System.out.println((i + 1) + ": " + primes[i]);
//    }



//    nDivisors(25200);
    int nrDivisors = 0;
    int number = 1;
    int triangleNumber = 1;
    while (nrDivisors < TARGET_NR_DIVISORS) {
      number++;
      triangleNumber += number;
      nrDivisors = nDivisors(triangleNumber);
    }
    System.out.println("Wynik: "+triangleNumber);
  }

  /**
   * Erastotenes sieve to find first 500 or so primes;
   */
  public static void setupPrimes() {
    int[] naturals = new int[BIGGEST_PRIME];
    for (int i = 0; i < naturals.length; i++) {
      naturals[i] = i;
    }
    int nthPrime = 2;
    for (int n = 0; n < primes.length; n++) {
      for (int nthPrimeMultiple = nthPrime*nthPrime; nthPrimeMultiple < BIGGEST_PRIME; nthPrimeMultiple+=nthPrime) {
        naturals[nthPrimeMultiple] = 0;
      }
      primes[n] = nthPrime;

      do {
        nthPrime++;
        if (nthPrime >= naturals.length) return;
      } while (naturals[nthPrime] == 0);
    }
  }

  /**
   * Finds the number of divisors of given number.
   * Also does prime factorization using prievously setup prime array.
   * @param number number.
   * @return number of divisors.
   */
  public static int nDivisors(int number) {
    int[] primesExponents = new int[NR_PRIMES];
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
    //find nr of divisors
    // (a+1)*(b+1)*(c+1)*...
    int nrDivisors = 1;
    for (int primesExponent : primesExponents) {
      if (primesExponent != 0) {
        //test
//        System.out.println(primes[i] + " ^ " + primesExponents[i]);
        nrDivisors *= (primesExponent + 1);
      }
    }
    return nrDivisors;
  }
}
