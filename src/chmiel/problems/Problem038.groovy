package chmiel.problems

import chmiel.utils.NumberUtils

//println "192384576: ${isPandigital(192384576)}"
//println "1922384576: ${isPandigital(1922384576)}"
//println "192 and (1,2,3): ${concatenatedProduct(192, [1,2,3])}"

def largestFound = 0

for (int i = 1; i < 10000; i++) {
    def numDigits = NumberUtils.getNumDigits(i)
    def minListSize = (int) ((numDigits + 11.0) / (numDigits +2.0))
    def maxListSize = 9 / numDigits

    //println i

    for (int j = minListSize; j <= maxListSize; j++) {
        //println 1..j
        def product = concatenatedProduct(i, 1..j)
        if (isPandigital(product)) {
            println("Found pandigital: $i \u00D7 ${1..j} = $product")
            if (product > largestFound) {
                largestFound = product
                println("Largest!")
            }
        }
    }
}
println "largestFound: $largestFound"


boolean isPandigital(long number) {
    def digitUsed = new boolean[9]
    while (number > 0) {
        int digit = number % 10
        number = number / 10
        if (digitUsed[digit-1] == true) {
            return false
        } else {
            digitUsed[digit-1] = true
        }
    }
    return !digitUsed.any {
        it == false
    }
}

long concatenatedProduct(number, multipliers) {
    Long.parseLong multipliers.inject("") {total, nextMultiplier ->
        total + nextMultiplier * number
    } as String
}