package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

prec = 10**11

sum = new TruncatingInteger(0, prec)
(1..1000).each {
  n = new TruncatingInteger((int)it, prec)
  power = n**n
  sum += power
  println "n: $n, n**n: ${power}, sum: $sum"
}
println sum