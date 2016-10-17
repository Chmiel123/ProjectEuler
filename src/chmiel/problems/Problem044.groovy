package chmiel.problems

import chmiel.utils.RuntimeUtils

RuntimeUtils.showExecutionTime()

long pentagonal(long n) {
  return n*(3*n-1)/2
}
boolean isPentagonal(long n) {
  isWhole((Math.sqrt(24*n+1)+1)/6)
}
boolean isWhole(double n) {
  n == (double)((long)n)
}
boolean isSqare(long n) {
  isWhole(Math.sqrt(n))
}

maxI = 1500
foundD = Integer.MAX_VALUE

// j > i > 0, P_i + P_j = Pentagonal, P_j - P_i = D -> min
for (int i = 1; i <= maxI; i++) {
  for (int di = 1; di <= maxI; di++) {
    j = i + di
    pi = pentagonal(i)
    pj = pentagonal(j)
    if (! isPentagonal(pi+pj) || !isPentagonal(pj-pi)) {
      continue
    }
    if (pj-pi < foundD) {
      foundD = pj-pi
      println ("Lowest D: $foundD, i: $i, j: $j")
    }
  }
}