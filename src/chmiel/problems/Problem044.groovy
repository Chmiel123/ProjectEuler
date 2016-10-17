package chmiel.problems

import chmiel.utils.*

RuntimeUtils.showExecutionTime()

maxI = 1500
foundD = Integer.MAX_VALUE

// j > i > 0, P_i + P_j = Pentagonal, P_j - P_i = D -> min
for (int i = 1; i <= maxI; i++) {
  for (int di = 1; di <= maxI; di++) {
    j = i + di
    pi = Numbers.pentagonal(i)
    pj = Numbers.pentagonal(j)
    if (! Numbers.isPentagonal(pi+pj) || ! Numbers.isPentagonal(pj-pi)) {
      continue
    }
    if (pj-pi < foundD) {
      foundD = pj-pi
      println ("Lowest D: $foundD, i: $i, j: $j")
    }
  }
}