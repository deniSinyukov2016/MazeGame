package Utils;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by Denis on 12.09.2016.
 */
public class TextureAtlas {

    private BufferedImage img = null;

    public  TextureAtlas (String imagePath){
        this.img = Loader.loadImage(imagePath);
    }

    //вырезает часть большего изображения по координатам x,y
    public  BufferedImage cut(int x, int y, int w, int h){
        return img.getSubimage(x,y,w,h);
    }

    //возвращает ширину изображения
    public int getWidth(){
        return img.getWidth();
    }

    //возвращает высоту изображения
    public int getHeight(){
        return img.getHeight();
    }
}


