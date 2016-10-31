package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

lowerLimit = 1000
upperLimit = 10000
primes = NumberUtils.setupPrimes(upperLimit).findAll {it >= lowerLimit}
//println (primes.size())

for (int i = 0; i<primes.size()-3; i++) {
  for (int j = i+1; j<primes.size()-2; j++){
    diff = primes[j] - primes[i]
    next = primes[j] + diff
    if (next > upperLimit) {
      break
    }
    if (!Numbers.isPrime(primes, next)) {
      continue
    }
    if (testPermutations([primes[i], primes[j], next])) {
      println "${primes[i]}, ${primes[j]}, $next"
    }
  }
}

boolean testPermutations(numbers) {
  firstDigits = Digits.getDigits(numbers[0]).toList().sort()
  for (int i=1; i<numbers.size(); i++) {
    digits = Digits.getDigits(numbers[i]).toList().sort()
    if (firstDigits != digits) {
      return false
    }
  }
  true
}