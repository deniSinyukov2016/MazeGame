package Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Denis on 02.09.2016.
 */
public class Loader {

    public static BufferedImage loadImage(String path){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        return img;
    }

    public  BufferedImage loadResourse(String path){
        BufferedImage img = null;
        try{
            img = ImageIO.read(getClass().getClassLoader().getResource(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        return img;
    }
}
