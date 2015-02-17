package chmiel.problems;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by kuba on 11.02.15.
 * 1 Jan 1901 to 31 Dec 2000
 */
public class Problem019 {

  private static final int START_YEAR = 1901;
  private static final int END_YEAR = 2000;

  public static void main(String[] args) {
    Calendar cal;
    int nrSundaysOnFirstDayOfMonth = 0;

    //year - 1900 ( 1 to 100)
    for (int year = START_YEAR; year <= END_YEAR; year++) {
      for (int month = 0; month < 12; month++) {
        cal = new GregorianCalendar(year, month, 1);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
          nrSundaysOnFirstDayOfMonth++;
        //System.out.println(cal);
      }
    }

    System.out.println(nrSundaysOnFirstDayOfMonth);
  }
}
