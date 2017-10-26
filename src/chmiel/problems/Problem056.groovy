package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

/*
A googol (10^100) is a massive number: one followed by one-hundred zeros;
100^100 is almost unimaginably large: one followed by two-hundred zeros.
Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100,
what is the maximum digital sum?
*/

biggest = 0
(1..99).each {BigInteger a ->
  (1..99).each {BigInteger b ->
    def sum = Digits.getDigits(a**b).sum()
    if (sum > biggest)
      biggest = sum
  }
}
println biggest