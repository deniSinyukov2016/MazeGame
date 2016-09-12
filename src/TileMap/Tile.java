package TileMap;

import Utils.Loader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Denis on 03.09.2016.
 */
public class Tile {

    private BufferedImage image;
    private int type;


    // tile types
    public static final int NORMAL = 0;
    public static final int BLOCKED = 1;

    public Tile(BufferedImage image, int type) {
        this.image = image;
        this.type = type;
    }

    public BufferedImage getImage() { return image; }
    public int getType() { return type; }

    public  void tick(){};

    public  void render(Graphics g){
        /*g.drawImage(img,x,y,bloakSize,bloakSize,null);*/
    }
}
