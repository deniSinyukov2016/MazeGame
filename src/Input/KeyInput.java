package Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

/**
 * Created by Denis on 02.09.2016.
 */
public class KeyInput implements KeyListener{

    public static boolean [] keys = new boolean[100];

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyInput.keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {KeyInput.keys[e.getKeyCode()] = false;}
}
