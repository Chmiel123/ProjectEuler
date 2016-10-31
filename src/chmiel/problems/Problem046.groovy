package chmiel.problems

import chmiel.utils.*

RuntimeUtils.showExecutionTime()

maxPrimes = 100000
maxPrimeMultiplicative = 1000
maxDoublePowers = 1000


primes = NumberUtils.setupPrimes(maxPrimes)
doublePowers = (1..maxDoublePowers).collect {n -> 2*n*n}

candidates = new long[primes.length][doublePowers.size()]
odds = [false] * (maxPrimeMultiplicative / 2)

/*for (int t = 0; t<primes.length; t++) {
  for (int dt = 1; dt<=t; dt++) {
    i = t-dt
    j = dt
    candidate = primes[i] + doublePowers[j]
    candidates[i][j] = candidate
  }
}*/

for (int i = 0; i<maxPrimeMultiplicative; i++) {
//primes.eachWithIndex {prime, i ->
  prime = primes[i]
  doublePowers.eachWithIndex {doublePower, j ->
    odds[(int)((prime+doublePower)/2)] = true
    //candidates[i][j] = prime + doublePower
  }
}
lowest = Integer.MAX_VALUE
odds.eachWithIndex {found, idx ->
  n = idx*2+1
  if (!found && !NumberUtils.isPrime(primes, n)) {
    if (n > 1 && lowest > n) {
      lowest = n
    }
  }
}
println lowest