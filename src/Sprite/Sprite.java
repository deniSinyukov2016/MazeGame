package Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Denis on 14.09.2016.
 */
public class Sprite {

    private SpriteSheet sheet;

    //размер изображения
    private float scale;

    public Sprite (SpriteSheet sheet, float scale){
        this.scale = scale;
        this.sheet = sheet;
    }

    //Отрисовка спрайта
    public void render(Graphics g, float x, float y){
        BufferedImage img = sheet.getSprite(0);
        g.drawImage(img,(int)x, (int)y, (int)(img.getWidth() * scale),(int)(img.getHeight() * scale),null);
    }


}
