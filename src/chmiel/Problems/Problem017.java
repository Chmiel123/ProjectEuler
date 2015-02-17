package chmiel.Problems;

import chmiel.utils.Appendable;
import chmiel.utils.IntAppend;
import chmiel.utils.StringAppend;

/**
 * Created by kuba on 10.02.15.
 */
public class Problem017 {

  /**
   * Class to store arrays of english numerals presented in various ways.
   */
  private static class NumeralsTab {
    public Object[] numerals0to19;
    public Object[] numerals00to90;
    public Object numeral100;
    public Object numeral1000;
    public Object wordAnd;
    public Object charHyphen;
    public Object charSpace;

    public NumeralsTab(Object[] numerals0to19, Object[] numerals00to90, Object numeral100, Object numeral1000, Object wordAnd, Object charHyphen, Object charSpace) {
      this.numerals0to19 = numerals0to19;
      this.numerals00to90 = numerals00to90;
      this.numeral100 = numeral100;
      this.numeral1000 = numeral1000;
      this.wordAnd = wordAnd;
      this.charHyphen = charHyphen;
      this.charSpace = charSpace;
    }
  }
  private static NumeralsTab wordNumerals;
  private static NumeralsTab letterCountNumerals;

  /**
   * called at start to initialize wordNumerals and letterCountNumerals.
   */
  private static void setup() {
    //word numerals initialized
    String[] numerals0to19 =
          {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                  "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] numerals00to90 =
            {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String numeral100 = "hundred";
    String numeral1000 = "thousand";

    //letter count numerals declaration
    Object[] letterNrNumerals0to19 = new Object[numerals0to19.length];
    Object[] letterNrnumerals00to90 = new Object[numerals00to90.length];
    Object letterNrNumeral100;
    Object letterNrNumeral1000;

    //letter count numerals initialization
    for (int i = 0; i < numerals0to19.length; i++) {
      letterNrNumerals0to19[i] = (numerals0to19[i].length());
    }
    for (int i = 0; i < numerals00to90.length; i++) {
      letterNrnumerals00to90[i] = (numerals00to90[i].length());
    }
    letterNrNumeral100 = numeral100.length();
    letterNrNumeral1000 = numeral1000.length();

    //special container types initialization;
    wordNumerals = new NumeralsTab(numerals0to19, numerals00to90, numeral100, numeral1000, "and", "-", " ");
    letterCountNumerals = new NumeralsTab(letterNrNumerals0to19, letterNrnumerals00to90, letterNrNumeral100, letterNrNumeral1000, 3, 0, 0);
  }

  /**
   * user method to convert int to written English.
   * @param number number to convert.
   * @return String with written English representation of the number.
   */
  private static String intToStringEnglishNumeral(int number) {
    return (String) (intToObjectEnglishNumeral(number, new StringAppend(), wordNumerals));
  }

  /**
   * user method to convert int to the number of letters a written English number would consist of.
   * @param number number to convert.
   * @return int the count of letters in a written English representation.
   */
  private static int intToLetterCountEnglishNumeral(int number) {
    return (Integer)intToObjectEnglishNumeral(number, new IntAppend(), letterCountNumerals);
  }

  /**
   * Low level method to find a representation of a number in written English.
   * @param number number to find representation of.
   * @param appendable a way to contatenate results.
   * @param tab struct with arrays of English numerals in any wanted format.
   * @return representation of the given number.
   */
  private static Object intToObjectEnglishNumeral(int number, Appendable appendable, NumeralsTab tab) {
    if (number < 0 || number > 1000)
      return null;
    int digit;
    boolean doSpace = false;
    //just zero
    if (number == 0) {
      appendable.append(tab.numerals0to19[0]);
      return appendable.getResult();
    }
    //digit of thousands
    digit = ((number / 1000) % 10);
    if (digit > 0) {
      appendable.append(tab.numerals0to19[digit]);
      appendable.append(tab.charSpace);
      appendable.append(tab.numeral1000);
      doSpace = true;
    }
    //digit of hundreds
    digit = ((number / 100) % 10);
    if (digit > 0) {
      if (doSpace) {
        appendable.append(tab.charSpace);
      }
      appendable.append(tab.numerals0to19[digit]);
      appendable.append(tab.charSpace);
      appendable.append(tab.numeral100);
      doSpace = true;
    }
    //tens and ones
    digit = (number % 100);
    if (digit != 0) {
      if (doSpace) {
        appendable.append(tab.charSpace);
        appendable.append(tab.wordAnd);
        appendable.append(tab.charSpace);
      }
      if (digit < 20) {
        appendable.append(tab.numerals0to19[digit]);
      } else {
        appendable.append(tab.numerals00to90[digit / 10]);
        digit = digit % 10;
        if (digit > 0) {
          appendable.append(tab.charHyphen);
          appendable.append(tab.numerals0to19[digit]);
        }
      }
    }
    return appendable.getResult();
  }


  public static void main(String[] args) {
    setup();
    IntAppend sumOfLetters = new IntAppend();

    for (int i = 1; i < 1001; i++) {
      sumOfLetters.append(intToLetterCountEnglishNumeral(i));
      //System.out.println(i+": "+intToStringEnglishNumeral(i)+" ("+intToLetterCountEnglishNumeral(i)+" letters)");
    }
    System.out.println(sumOfLetters.getResult());
  }
}
