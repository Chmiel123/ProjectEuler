package chmiel.utils

class Prime {
  
  def primes
  
  Prime(int n) {
    def naturals = new BitField(n)
    def result = []

    int nthPrime = 2
    def finished = false
    
    while (!finished) {
      for (int nthPrimeMultiple = nthPrime*nthPrime; nthPrimeMultiple < n && nthPrimeMultiple >= 0; nthPrimeMultiple+=nthPrime) {
        naturals[nthPrimeMultiple] = true;
      }
      result.add(nthPrime)
      if (nthPrime < 0) {
        println "\nWTF, nthPrime: $nthPrime"
      }
      Progress.update("Prime setup [nthPrime: $nthPrime] [${(int)(nthPrime * 100.0 / n)} %]", 10000)
      nthPrime++
      while (nthPrime < naturals.length && naturals[nthPrime] == true) {
        nthPrime++
      }
      if (nthPrime >= naturals.length) {
        primes = result as int[]
        finished = true
      }
    }
    Progress.reset()
  }
  
  boolean isPrime(int testedNumber) {
    if (primes[primes.length - 1] < testedNumber) {
      throw new ArithmeticException("Error, too few primes (tested: $testedNumber, lastPrime: ${primes[primes.length - 1]})")
    }
    return (Arrays.binarySearch(primes, testedNumber) >= 0);
  }
}