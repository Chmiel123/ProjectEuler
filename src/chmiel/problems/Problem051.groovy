package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

/*
By replacing the 1st digit of the 2-digit number *3, it turns out that
six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit,
this 5-digit number is the first example having seven primes among
the ten generated numbers, yielding the family:
56003, 56113, 56333, 56443, 56663, 56773, and 56993.
Consequently 56003, being the first member of this family,
is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number
(not necessarily adjacent digits) with the same digit, is part of an
eight prime value family.
*/

nDigits = 6
maxPrimes = 10 ** nDigits
minPrimes = 10 ** (nDigits - 1)
target = 8

primes = NumberUtils.setupPrimes(maxPrimes).findAll { it > minPrimes }

//println "first prime: ${primes.first()}, last: ${primes.last()}"

subs = (0..(nDigits - 2)).subsequences()

results = [:]
smallest = [:]
primes.each { prime ->
  subs.each { swapIndexes ->
    digits = NumberUtils.getDigits(prime).toList().reverse()
    int commonDigit = digits[swapIndexes.first()]
    fail = false
    swapIndexes.each {
      if (digits[it] != commonDigit)
        fail = true
    }
    if (!fail) {
      swapIndexes.reverse().each{ digits.removeAt(it) }
      if (results[swapIndexes] == null)
        results[swapIndexes] = [:]
      if (results[swapIndexes][digits] == null) {
        results[swapIndexes][digits] = 1
        smallest[[swapIndexes,digits]] = prime
      }
      else
        results[swapIndexes][digits] ++
    }
  }
}
results.each {swapK, swapV ->
  swapV.each {numK, numV ->
    if (numV >= target) {
      println "swap: $swapK, num: $numK, $numV\nanswer: ${smallest[[swapK,numK]]}"
    }
  }
}