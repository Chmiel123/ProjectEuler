package chmiel.problems

import chmiel.utils.NumberUtils

def nArray = (0..6).collect{10**it}
def found = []
def numbersBefore = 0

//Each iteration corresponds to a range of numbers with the same number of digits (1-9, 10-99, 100-999, ...)
for (int digits = 1; digits <= 8; digits++) {
    //number of numbers in the range (10-99 -> 90 numbers)
    def numbers = 9*10**(digits-1)

    nArray.findAll {it >= 1 && it <= numbers * digits}.each {
        def number = (numbersBefore + (it-1) / digits + 1) as int
        def digitInNumber = (it-1) % digits
        def digitized = NumberUtils.getDigits(number).toList().reverse()

        found << digitized[digitInNumber]
    }

    nArray = nArray.collect{ it - numbers * digits}
    numbersBefore += numbers
}
println found.inject(1) {current, next -> current * next}