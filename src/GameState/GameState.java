package GameState;

import java.awt.*;

/**
 * Created by Denis on 02.09.2016.
 */
public abstract class GameState {
    private GameStateManager gsm;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;

    }
    public abstract void init();
    public abstract void tick();
    public abstract void handleInput();
    public abstract void render(Graphics g);

}
