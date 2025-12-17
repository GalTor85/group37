package OpenClosedPrinciple;

import javax.swing.*;

public class PrintToWindow extends Print {
    private JFrame window;


    public JFrame getWindow() {
        return window;
    }

    @Override
    public void print(String text) {
        window = new JFrame();
        getWindow().getContentPane().add(new JLabel(text));

        getWindow().setSize(300, 50);
        getWindow().setVisible(true);
        getWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
