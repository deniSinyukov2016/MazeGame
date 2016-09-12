package GameState;

import Input.KeyInput;
import Main.Board;
import Utils.Loader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Denis on 02.09.2016.
 */
public class MenuState extends GameState {

    private  Font fontTextTitle;
    private  Font fontTextMenu;
    private String title = null;
    private  String []  menuName= {"Start","Exit"};
    private int currentSelection ;//текущий выбранный
    private BufferedImage image = null;
    private  GameStateManager gsm ;
    private ArrayList<GameState> states;

    //private Level_1 level_1;

    public MenuState(GameStateManager gsm){
        super(gsm);
        this.gsm = gsm;

        init();

    }
    @Override
    public void init() {

        states = new ArrayList<GameState>();
        states.add(new Level_1(gsm));
        states.add(new Level2(gsm));
        currentSelection = 0;
        fontTextTitle = new Font("Arial",Font.BOLD,56);
        fontTextMenu = new Font("Arial",Font.PLAIN,20);
        title = "M A Z E";
        image = Loader.loadImage("images/img_menu/doble.png");


    }

    @Override
    public void tick() {
        handleInput();
    }

    @Override
    public void handleInput() {
        if(KeyInput.keys[KeyEvent.VK_UP]){
            currentSelection--;
            if(currentSelection< 0)currentSelection = menuName.length-1;
        }
        if(KeyInput.keys[KeyEvent.VK_DOWN]){
            currentSelection++;
            if(currentSelection == menuName.length)currentSelection = 0;
        }
        if(KeyInput.keys[KeyEvent.VK_ENTER]){
//            if(currentSelection == 0){
//               gsm.setGameStates(states.get(currentSelection));
//
//            }else if(currentSelection == 1){System.exit(0);}
//            else if(currentSelection == 2){
//                gsm.setGameStates(states.get(currentSelection));
//            }
            if(currentSelection <=0)
            gsm.setGameStates(states.get(currentSelection));
            else System.exit(0);
        }


    }



    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, Board.WIDTH,Board.HEIGTH);
        g.setColor(Color.WHITE);
        g.setFont(fontTextTitle);
        g.drawString(title,240 ,240);
        g.setFont(fontTextMenu);
        for (int i = 0; i <menuName.length ; i++) {
            g.drawString(menuName[i],300,300+i*30);
        }
        if(currentSelection == 0){
            g.drawImage(image,275,282,null);
        }else if(currentSelection == 1) {
            g.drawImage(image, 275, 312, null);
        }
    }

}
