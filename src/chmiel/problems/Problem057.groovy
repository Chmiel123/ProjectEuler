package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()


FractionG iter(FractionG frac) {
  frac.add(FractionG.ONE).reverse().add(FractionG.ONE)
}

frac = new FractionG(3,2)
count = 0
1000.times {
  //print "${it+1}: $frac"
  if (Digits.getDigits(frac.getNominator()).size() > Digits.getDigits(frac.getDenominator()).size()){
    //print "  <"
    count++
  }
  frac = iter(frac)
  
  //println ()
}
println "count: $count"