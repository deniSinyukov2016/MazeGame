package Main;

import GameState.GameStateManager;
import Input.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Denis on 02.09.2016.
 */

public class Board extends JPanel implements Runnable {

    public static final int WIDTH = 640;//ширина
    public static final int HEIGTH = 520;//высота
    private Color colorBackground ;//цвет фона

    private long start,elepsed,wait;
    private boolean isRinning = false;
    private Thread thread ;
    private  int FPS = 10;
    private int targetTime = 1000/ FPS;

    private GameStateManager gsm;


    public Board(){
        setPreferredSize(new Dimension(WIDTH,HEIGTH));
        init();
        addKeyListener(new KeyInput());
        setFocusable(true);

    }



    public void init (){
        colorBackground = Color.black;
        gsm = new GameStateManager();
        gsm.init();
        start();

    }

    public void start(){
        isRinning = true;
        thread = new Thread(this);
        thread.start();
    }
    public void tick(){
        System.out.println("Run");
        gsm.tick();
    }
    public void paint(Graphics g){

        gsm.render(g);
        g.setColor(Color.blue);
        g.drawString("FPS: "+wait,10,20);


    }

    @Override
    public void run() {

        while (isRinning){
            start = System.nanoTime();
            tick();
            repaint();
            elepsed = (System.nanoTime()- start)/1000000;
            wait = targetTime - elepsed ;

            //if(wait <=0) wait = 5;
            try {
                Thread.sleep(wait);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
