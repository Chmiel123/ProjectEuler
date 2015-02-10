package chmielu;

/**
 * Created by kuba on 10.02.15.
 * Is an abstraction of the way StringBuilder or summing to an int would work.
 */
public interface Appendable {
  /**
   * appends new element to those already appended.
   * @param ob new element.
   */
  void append(Object ob);

  /**
   * Gets the result of all the appends that happened.
   * @return result of all appends.
   */
  Object getResult();
}
