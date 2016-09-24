package chmiel.problems

import chmiel.utils.NumberUtils

primes = NumberUtils.setupPrimes(35000)
//pandigitals 1..9 and 1..8 fail, because sum of digits is divisible by 3 => number is also divisible by 3
digits = (7..1).toList()

largest = 2;
fabricatePandigitNumber(0, digits)

void fabricatePandigitNumber(long soFar, List<Integer> digitsLeft) {
    if (digitsLeft.empty) {
        digestPandigit(soFar)
    }
    digitsLeft.each {
        fabricatePandigitNumber(soFar * 10 + it, digitsLeft.findAll {digit -> digit != it})
    }
}

void digestPandigit(long pandigit) {
    if (isPrime(pandigit) && pandigit > largest) {
        largest = pandigit
        println largest
    }
}
boolean isPrime(long number) {
    def sqrt = (long) Math.sqrt(number)
    if (primes[primes.length - 1] <= sqrt)
        return true

    for (int it : primes) {
        if (number % it == 0l)
            return false
    }
    return true
}