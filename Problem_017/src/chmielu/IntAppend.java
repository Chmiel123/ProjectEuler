package chmielu;

/**
 * Created by kuba on 10.02.15.
 * Adds each number up, starting from 0.
 */
public class IntAppend implements Appendable {
  private int sum = 0;

  @Override
  public void append(Object ob) {
    sum += (Integer)ob;
  }

  @Override
  public Object getResult() {
    return sum;
  }
}
