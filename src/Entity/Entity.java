package Entity;

import java.awt.*;

/**
 * Created by Denis on 03.09.2016.
 */
public abstract class Entity {

//    private int x = 10;
//    private int y = 10;
//    private int width = 25 ;
//    private int heigth = 5;

//    public Entity(int width, int heigth){
//        this.width = width;
//        this.heigth = heigth;
//    }

    public abstract void init();
    public abstract void render(Graphics g);
    public abstract void tick();
    public abstract void handleInput();
}
