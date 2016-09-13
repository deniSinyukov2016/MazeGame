package Sprite;

import java.awt.image.BufferedImage;

/**
 * Created by Denis on 14.09.2016.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    //кол-во спрайтов
    private  int spriteCout;

    //размер одного спрайта
    private int scale;

    //кол-во спрайтов в ширину
    private  int spriteInWidth;

    public SpriteSheet(BufferedImage sheet, int spriteCout, int scale){
        this.sheet = sheet;
        this.spriteCout = spriteCout;
        this.scale = scale;

        //Ширина картинки / размер одного спрайта(пикселей)
        this.spriteInWidth = sheet.getWidth() / scale;
    }


    public BufferedImage getSprite(int index) {

        //для условия если картинка спрайтов будет расти
        index = index % spriteCout;

        int x = index % spriteInWidth * scale;
        int y = index / spriteInWidth * scale;

        return sheet.getSubimage(x,y,scale,scale);
    }
}
