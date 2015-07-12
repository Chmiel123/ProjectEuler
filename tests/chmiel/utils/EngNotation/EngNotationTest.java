package chmiel.utils.EngNotation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kuba on 2015-07-11.
 */
public class EngNotationTest {
  private EngNotation sec;
  private EngNotation gram;

  @Before
  public void setUp() throws Exception {
    sec = new EngNotation("s");
    gram = new EngNotation("g");
  }

  @Test
  public void secget_0c0131_13c100ms() throws Exception {
    double input = 0.0131;
    String result = sec.get(input);
    assertEquals("13,100ms", result);
  }

  @Test
  public void secget_0c999999_999c999ms() throws Exception {
    double input = 0.999999;
    String result = sec.get(input);
    assertEquals("999,999ms", result);
  }

  @Test
   public void secget_12c0001_12s() throws Exception {
    double input = 12.0001;
    String result = sec.get(input);
    assertEquals("12,000s", result);
  }

  @Test
  public void gramget_1000c49999999999_1c000kg() throws Exception {
    double input = 1000.499999999;
    String result = gram.get(input);
    assertEquals("1,000kg", result);
  }
  @Test
  public void gramget_15tril_15c000Tg() throws Exception {
    double input = 15_000_000_000_000.0;
    String result = gram.get(input);
    assertEquals("15,000Tg", result);
  }
}