package TileMap;

import Sprite.SpriteSheet;
import Utils.Loader;
import Utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Denis on 03.09.2016.
 */
public class Tile {

    //изображение для тайла
    private BufferedImage image;

    //Тип тайла , берется из  enum TileTipe
    private TileType tileType;


    // tile types
    public static final int NORMAL = 0;
    public static final int BLOCKED = 1;

    public Tile(BufferedImage image, int scale, TileType tileType) {
        this.image = Utils.resize(image, image.getWidth() * scale, image.getHeight() * scale);
        this.tileType = tileType;
    }

    //Обновление тайла
    public void tick() {
    }



    //Отрисовка тайла
    public void render(Graphics g,int x, int y) {
        g.drawImage(image,x,y,null);
    }


    public BufferedImage getImage() {
        return image;
    }

    public TileType getType() {
        return tileType;
    }
}
