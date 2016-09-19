package Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 02.09.2016.
 */
public class Loader {

    public static final String PATH_FOLDER = "res/";

    public static BufferedImage loadImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(PATH_FOLDER + path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static Integer [][] loadLevev(String path){

        Integer [][] result = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(PATH_FOLDER+path)))) {

            String line = null;
            List<Integer []> lvlLines = new ArrayList<Integer[]>();
            while ((line = reader.readLine())!=null) {
                lvlLines.add(strToInt_array(line.split(" ")));
            }
            result = new Integer[lvlLines.size()][lvlLines.get(0).length];
            for (int i = 0; i <lvlLines.size() ; i++) {
                result[i] = lvlLines.get(i);
            }
        }catch (IOException e){
                e.printStackTrace();
            }

            return result;
        }

        public static final Integer [] strToInt_array(String [] arr){
            Integer [] res = new Integer[arr.length];
            for (int i = 0; i <arr.length ; i++) {
                res[i] = Integer.parseInt(arr[i]);
            }
            return res;
        }
    }


