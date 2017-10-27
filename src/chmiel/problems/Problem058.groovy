package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

/*
Starting with 1 and spiralling anticlockwise in the
following way, a square spiral with side length 7
is formed.

37 36 35 34 33 32 31
38 17 16 15 14 13 30
39 18  5  4  3 12 29
40 19  6  1  2 11 28
41 20  7  8  9 10 27
42 21 22 23 24 25 26
43 44 45 46 47 48 49

It is interesting to note that the odd squares lie along
the bottom right diagonal, but what is more interesting
is that 8 out of the 13 numbers lying along both
diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

If one complete new layer is wrapped around the spiral
above, a square spiral with side length 9 will be formed.
If this process is continued, what is the side length of
the square spiral for which the ratio of primes along
both diagonals first falls below 10%?
*/

//sieveSize = 90000000
//p = new Prime(sieveSize)

ratioThreshold = 0.1
nPrimes = 0
nTotal = 1
number = 1g
iter = 0
finished = false
side = 0

println "Start"
while (!finished) {
  iter++
  4.times {
    number += iter * 2
    try {
      if (number.isProbablePrime(100)) {
        nPrimes++
      }
    } catch(ArithmeticException e) {
      println "\n$e"
      finished = true
    }
    nTotal++
  }
  //check ratio
  def ratio = (double)nPrimes / nTotal
  if (ratio < ratioThreshold)
    finished = true
  side = iter * 2 + 1
  //println "primes: $nPrimes, total: $nTotal"
  //println "iteration: $iter, side: $side, ratio: $ratio"
  
  Progress.update("iteration: $iter, side: $side, ratio: $ratio", 100)
  
}
println()
println "Side: $side"


