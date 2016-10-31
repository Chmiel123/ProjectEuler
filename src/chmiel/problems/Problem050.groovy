package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

upperLimit = 1000000
primes = NumberUtils.setupPrimes(upperLimit).toList()

mostPrimesSum = 0
mostPrimesSize = 0

for (int i=0; i<primes.size(); i++) {
  if (i % 1000 == 0) {
    println "Progress: $i / ${primes.size()}"
  }
  for (int di=1; i+di<primes.size(); di++) {
    selectedPrimes = primes[i..(i+di)]
    sum = selectedPrimes.inject(0) { result, next -> result + next }
    if (sum > primes.last()) {
      break
    }
    if (Numbers.isPrime(primes, sum) && selectedPrimes.size() > mostPrimesSize) {
      mostPrimesSum = sum
      mostPrimesSize = selectedPrimes.size()
      println "Largest so far: $mostPrimesSum is sum of $mostPrimesSize consecutive primes."
    }
  }
}