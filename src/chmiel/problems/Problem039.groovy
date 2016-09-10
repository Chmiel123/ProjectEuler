package chmiel.problems

def final maxPerimeter = 1000

def squares = (1..maxPerimeter/2).collect{it * it}

def integerRoot = {int number -> squares.findIndexOf {it == number} + 1}
def rightTriangles = new int[maxPerimeter + 1]


for (int a = 1; a < maxPerimeter / 2; a++) {
    for (int b = a + 1; b < maxPerimeter / 2; b++) {
        def c = integerRoot( a*a + b*b )
        if (c > 0 && a+b+c <= 1000) {
            println "Found {$a, $b, $c}"
            rightTriangles[a+b+c] ++
        }
    }
}
def largest = 0
rightTriangles.eachWithIndex { int entry, int i ->
    if (entry > largest) {
        largest = entry
        println "perimeter: $i, triangles: $entry"
    }
}