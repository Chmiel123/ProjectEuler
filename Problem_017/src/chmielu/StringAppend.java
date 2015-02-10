package chmielu;

/**
 * Created by kuba on 10.02.15.
 * Wrapper of StringBuilder class with use of the Appendable interface for abstraction.
 */
public class StringAppend implements Appendable {
  private StringBuilder sb;

  public StringAppend() {
    sb = new StringBuilder();
  }

  @Override
  public void append(Object ob) {
    sb.append((String) ob);
  }

  @Override
  public Object getResult() {
    return sb.toString();
  }
}
