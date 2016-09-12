package GameState;

import Entity.Heroy;
import Entity.Player;
import Input.KeyInput;
import Main.Board;
import TileMap.TileMap;
import Utils.Loader;
import javafx.scene.layout.Background;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Denis on 03.09.2016.
 */
public class Level_1 extends GameState {

    private Player player;
    private Heroy heroy;
    private TileMap tileMap;
    private BufferedImage bg;



    public Level_1(GameStateManager gsm) {
        super(gsm);
        init();
    }




    @Override
    public void init() {
        //player = new Player();
        tileMap = new TileMap(30);
        heroy = new Heroy(tileMap);

        heroy.setX(150);
        heroy.setY(50);
        bg = Loader.loadImage("bg.gif");

    }



    @Override
    public void tick() {

        //player.tick();
        heroy.tick();
        tileMap.tick();
        handleInput();

    }

    @Override
    public void handleInput() {

        if(KeyInput.keys[KeyEvent.VK_LEFT]) heroy.setLeft(true);
        if(KeyInput.keys[KeyEvent.VK_RIGHT]) heroy.setRight(true);

    }

    @Override
    public void render(Graphics g) {

//        g.setColor(Color.WHITE);
//        g.fillRect(0,0, Board.WIDTH,Board.HEIGTH);
        g.drawImage(bg,0,0,Board.WIDTH,Board.HEIGTH,null);

        tileMap.render(g);
        heroy.render(g);
       // player.render(g);
    }
}
