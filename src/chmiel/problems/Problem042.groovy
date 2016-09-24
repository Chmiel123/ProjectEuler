package chmiel.problems

input = new File("../../../inputs/P_042.txt").text
input = input.replace("\"", "")
words = input.split(",")

println words.findAll {isTriangle(wordValue(it))}.size()

int wordValue(String s) {
    s.collect {charValue(it as char)}.sum() as int
}
int charValue(char c) {
    c.toLowerCase() - ((char)'a') + 1
}
//solved t_n = ?n(n+1) for n
boolean isTriangle(int number) {
    def n = Math.sqrt(2.0*number + 0.25) - 0.5
    n - Math.floor(n) == 0.0
}