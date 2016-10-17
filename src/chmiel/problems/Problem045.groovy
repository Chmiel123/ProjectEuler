package chmiel.problems

import chmiel.utils.*

RuntimeUtils.showExecutionTime()

//T_285 = P_165 = H_143 = 40755

maxN = 1000000
firstN = 286

for (n = firstN; n <= maxN; n++) {
  t_n = Numbers.triangle(n)
  if (Numbers.isPentagonal(t_n) && Numbers.isHexagonal(t_n)) {
    println "Finished: n=$n, t_n=$t_n"
    break
  }
}