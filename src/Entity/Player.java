package Entity;

import Input.KeyInput;
import Utils.Loader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Denis on 03.09.2016.
 */
public class Player extends Entity {

    private int x ;
    private int y ;
    private int width ;
    private int heigth;

    private BufferedImage img = null;
    private  String URL_player = "res/images/img_entity/player.png";



    public Player( ) {
        init();
    }

    @Override
    public void init() {
        x = 10;
        y = 40;
        width = 20;
        heigth = 20;
        img = Loader.loadImage(URL_player);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, getX(), getY(),width,heigth,null);
    }

    @Override
    public void tick() {

        handleInput();
    }

    @Override
    public void handleInput() {
        if(KeyInput.keys[KeyEvent.VK_UP]){
            y = getY() - 5;
        }
        if(KeyInput.keys[KeyEvent.VK_DOWN]){
            y = getY() + 5;
        }
        if(KeyInput.keys[KeyEvent.VK_RIGHT]){
            x = getX() + 5;
        }
        if(KeyInput.keys[KeyEvent.VK_LEFT]){
            x = getX() - 5;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
