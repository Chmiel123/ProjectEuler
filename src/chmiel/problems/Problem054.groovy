package chmiel.problems
import chmiel.utils.*
RuntimeUtils.showExecutionTime()

/*
In the card game poker, a hand consists of five cards and are ranked,
from lowest to highest, in the following way:

    High Card: Highest value card.
    One Pair: Two cards of the same value.
    Two Pairs: Two different pairs.
    Three of a Kind: Three cards of the same value.
    Straight: All cards are consecutive values.
    Flush: All cards of the same suit.
    Full House: Three of a kind and a pair.
    Four of a Kind: Four cards of the same value.
    Straight Flush: All cards are consecutive values of same suit.
    Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest
value wins; for example, a pair of eights beats a pair of fives
(see example 1 below). But if two ranks tie, for example,
both players have a pair of queens, then highest cards in each hand are
compared (see example 4 below); if the highest cards tie then the next
highest cards are compared, and so on.

The file, poker.txt, contains one-thousand random hands dealt to two players.
Each line of the file contains ten cards (separated by a single space):
the first five are Player 1's cards and the last five are Player 2's cards.
You can assume that all hands are valid (no invalid characters or repeated
cards), each player's hand is in no specific order, and in each hand there
is a clear winner.

How many hands does Player 1 win?
*/
enum Suit {
  H("H"),
  D("D"),
  S("S"),
  C("C")
  
  def String c
  Suit(String c) {
    this.c = c
  }
}
enum Value {
  TWO("2", 2),
  THREE("3", 3),
  FOUR("4", 4),
  FIVE("5", 5),
  SIX("6", 6),
  SEVEN("7", 7),
  EIGHT("8", 8),
  NINE("9", 9),
  TEN("T", 10),
  JACK("J", 11),
  QUEEN("Q", 12),
  KING("K", 13),
  ACE("A", 14)
  
  def String c
  def int power
  private Value(String c, int power) {
    this.c = c
    this.power = power
  }
  static Value get(String c) {
    values().find { it.c == c}
  }
  String toString() {
    c
  }
}
class Card {
  def final Suit suit
  def final Value value
  
  Card (Suit suit, Value value) {
    this.suit = suit
    this.value = value
  }
  Card (String s) {
    this.suit = s[1]
    this.value = Value.get(s[0])
  }
  String toString() {
    "$value$suit"
  }
}
class Hand {
  def cards
  
  Hand (cards) {
    this.cards = cards.toSorted {a, b -> a.value <=> b.value}
  }
  boolean isSameSuit() {
    def suit = cards.first().suit
    cards.every {it.suit == suit}
  }
  boolean isStraight() {
    def v = cards.first().value.power
    def success = true
    cards.each {
      if (it.value.power != v)
        success = false
      v++
    }
    success
  }
  def getOccurences() {
    def occurences = [:]
    cards.each {card ->
      if (occurences[card.value] == null)
        occurences[card.value] = 1
      else
        occurences[card.value]++
    }
    occurences.sort {it.value}
  }
  int score() {
    def occurs = getOccurences()
    //println occurs
    //straight flush================================
    if (isSameSuit() && isStraight())
      return(9000000
             + 10000 * cards.last().value.power)
    //four==========================================
    if (occurs.any {it.value == 4})
      return(8000000
             + 10000 * occurs.keySet().last().power
               + 100 * occurs.keySet().first().power)
    //full house====================================
    if (occurs.values()[0] == 2 && occurs.values()[1] == 3)
      return(7000000
             + 10000 * occurs.keySet()[1].power
               + 100 * occurs.keySet()[0].power)
    //flush=========================================
    if (isSameSuit())
      return(6000000
             + 10000 * cards.last().value.power)
    //straight======================================
    if (isStraight())
      return(5000000
             + 10000 * cards.last().value.power)
    //three=========================================
    if (occurs.any {it.value == 3})
      return(4000000
             + 10000 * occurs.keySet().last().power
               + 100 * occurs.findAll{it.value==1}.max{it.key.power}.key.power)
    //two pairs=====================================
    if ((occurs.findAll{it.value == 2}.size()) == 2)
    return(3000000
           + 10000 * occurs.findAll {it.value == 2}.max{it.key.power}.key.power
             + 100 * occurs.findAll {it.value == 2}.min{it.key.power}.key.power
               + 1 * occurs.find {it.value == 1}.key.power)
    //pair==========================================
    if (occurs.any {it.value == 2})
    return(2000000
           + 10000 * occurs.find {it.value == 2}.key.power
             + 100 * occurs.findAll {it.value == 1}.max{it.key.power}.key.power)
    //high cards====================================
    cards.last().value.power
  }
}






player1Wins = 0
lines = new File("../inputs/P_054.txt").readLines()
lines.each { line ->
  def cards = line.split(' ')
  def p1 = new Hand(cards.take(5).collect{new Card(it)})
  def p2 = new Hand(cards.drop(5).collect{new Card(it)})
  
  if (p1.score() > p2.score())
    player1Wins++
  //println "p1: ${p1.cards}, score: ${p1.score()} | p2: ${p2.cards}, score: ${p2.score()}"
}
println "Player 1 won $player1Wins times"