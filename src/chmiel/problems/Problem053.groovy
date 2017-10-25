package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

/*
There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, 5C3 = 10.

In general,
nCr =

   n!
--------
r!(n−r)!

,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.

It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100,
  are greater than one-million?
*/

BigInteger ncr(n, r) {
  Numbers.factorial(n) / Numbers.factorial(r) / Numbers.factorial(n-r)
}

double fraction(num, den) {
  double result = 1.0
  num.each { result *= it }
  den.each { result /= it }
  result
}

count = 0

(6..100).each {n ->
  (1..n-1).each {r ->
    num = ((n-r+1)..n).toList()
    den = (1..(r)).toList()
    res = fraction(num, den)
    if (res > 1000000)  {
      count++
      //println "n: $n, r: $r, ncr: ${ncr(n,r)}"
      //println "estimate ncr: ${res}"
    }
    //println "over 1 mln: ${res > 1000000}"
  }
}
println "count: $count"