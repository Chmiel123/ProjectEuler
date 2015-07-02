package chmiel.Executor;

import javax.swing.*;

/**
 * Created by Kuba on 2015-07-02.
 */
public class Executor {
  public static void main(String[] args) {
    JFrame frame = new JFrame("ExecutorGUI");
    frame.setContentPane(new ExecutorGUI().getPanel());
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
