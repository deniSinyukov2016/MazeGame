package Main;

import javax.swing.*;

/**
 * Created by Denis on 02.09.2016.
 */
public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Game MAZE");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new Board());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
