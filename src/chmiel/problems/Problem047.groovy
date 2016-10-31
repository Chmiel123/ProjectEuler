package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

maxPrime = 1000000
maxN = maxPrime

m = 4

primes = NumberUtils.setupPrimes(maxPrime)
lastMnumbers = [false] * m

void advanceMnumbers(lastMnumbers) {
  lastMnumbers.pop()
  lastMnumbers.add(0, false)
}

for (int n = 4; n < maxN; n++) {
  advanceMnumbers(lastMnumbers)
  primeFactors = numOfPrimeFactors(n, primes, m)
  if (primeFactors == m) {
    lastMnumbers[0] = true
  }
  if (lastMnumbers.every {it}) {
    println "Found!"
    (0..(m-1)).each {
      println (n - it)
    }
    return
  }
  //if (n % 1000 == 0) { println "$n / $maxN" }
}

int numOfPrimeFactors(int number, int[] primes, int maxNumOfPrimeFactors) {
    int factors = 0
    if ((long)primes[primes.length-1]*primes[primes.length-1] < number) {
      System.err.println("Too few primes")
      System.exit(-1)
    }
    //find exponents of prime factorization
    // n = p1^a * p2^b * p3^c * ...
    for (int n = 0; n < primes.length; n++) {
      if (number % primes[n] == 0) {
        factors++
        if (factors > maxNumOfPrimeFactors) {
          return -1
        }
      }
      if (number < primes[n])
        break
    }
    return factors
  }