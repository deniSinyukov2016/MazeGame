package GameState;

import Main.Board;

import java.awt.*;

/**
 * Created by Denis on 08.09.2016.
 */
public class Level2 extends GameState {


    public Level2(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect(0,0, Board.WIDTH,Board.HEIGTH);
    }
}
