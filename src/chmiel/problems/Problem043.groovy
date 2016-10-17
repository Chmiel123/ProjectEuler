package chmiel.problems

import chmiel.utils.*

RuntimeUtils.showExecutionTime()

subNumbers = [2,3,5,7,11,13,17]
long total = 0
size = 0

checkNumber(1406357289l)

Digits.digitPermutations(0..9) { pandigital ->
    if (checkNumber(pandigital)) {
        size++
        total += pandigital
        println "$size found, last number: $pandigital, total sum: $total"
    }
}

println "All done, total sum: $total"


boolean checkNumber(long pandigital) {
    if (pandigital < 1000000000) return false
    def digits = Digits.getDigits(pandigital)
    def isGood = true
    (2..8).eachWithIndex {num, idx ->
        def number = Digits.glueDigits([digits[num-1], digits[num], digits[num+1]])
        //noinspection GroovyAssignabilityCheck
        if (number % subNumbers[idx] != 0)
            isGood = false
    }
    return isGood
}