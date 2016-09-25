package chmiel.utils

class Digits {
    /**
     * Get an array of decimal digits of a number.
     * @param number number.
     * @return array of digits.
     */
    static int[] getDigits(long number) {
        getDigits(number, 10)
    }
    /**
     * Get an array of digits of a number in a specified base.
     * @param number number.
     * @param base base.
     * @return array of digits.
     */
    static int[] getDigits(long number, int base) {
        def digits = []
        while (number > 0) {
            digits << number % base
            number /= base
        }
        digits.reverse()
    }
    /**
     * Concatenates list of digits to form a number (ex. [1, 2, 3] -> 123)
     * @param digits list of digits
     * @return number
     */
    static int glueDigits(List<Integer> digits) {
        def result = 0
        digits.each {
            result *= 10
            result += it
        }
        result
    }

    /**
     * Finds depth first all numbers that are permutations of input digits, and performs a closure on each of them.
     * @param digits list of digits.
     * @param closure function that performs on the result numbers.
     */
    static void digitPermutations(Collection<Integer> digits, Closure closure) {
        fabricateDigitPermutations(0l, digits, closure)
    }
    private static void fabricateDigitPermutations(long soFar, Collection<Integer> digits, Closure closure) {
        if (digits.empty) {
            closure(soFar)
        }
        digits.each {
            fabricateDigitPermutations(soFar * 10 + it, digits.findAll {digit -> digit != it}, closure)
        }
    }
}
