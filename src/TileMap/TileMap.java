package TileMap;

import Entity.Player;
import Main.Board;
import Sprite.SpriteSheet;
import Utils.Loader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Denis on 04.09.2016.
 */
public class TileMap {

    private int x;
    private int y;
    private int tileSize;
    private int[][] map ;
    private int mapWidth;
    private int mapHeight;
    private SpriteSheet sheet;

    private static final String URL_MAP = "res/Maps/mapLevel.txt";

    public TileMap(int tileSize) {
        this.tileSize = tileSize;
        sheet = new SpriteSheet(Loader.loadImage("images/playerSprite.png"),3,32);
        loadMap(URL_MAP);


    }


    //Загрузка карты из файла
    public void loadMap(String s) {

        try  (BufferedReader br = new BufferedReader(new FileReader(s))){

//            FileInputStream fstream = new FileInputStream(s);//читает из файла
//            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            mapWidth = Integer.parseInt(br.readLine());
            mapHeight = Integer.parseInt(br.readLine());
            map = new int[mapHeight][mapWidth];
            String delimiters = "\\s+";;//разделители

            for (int row = 0; row < mapHeight; row++) {
                String line = br.readLine();
                String[] tokens = line.split(delimiters);
                for (int col = 0; col < mapWidth; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Обновление
    public void tick(){

    }


    //Отрисовка
    public void render(Graphics g) {

        for (int row = 0; row < mapHeight; row++) {
            for (int col = 0; col < mapWidth; col++) {

                int rc = map[row][col];
                if(rc == 0){
                    g.drawImage(sheet.getSprite(1),map[row][col],map[row][col],null);
                }else if(rc == 1){
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x+ row * tileSize, y+col  * tileSize,tileSize,tileSize);
            }
        }
    }

    public  int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getColTile(int x){
        return x / tileSize;
    }

    public  int getRowTile(int y){
        return y / tileSize;
    }

    public int getTile(int row, int col){
        return map[row][col];
    }

    public  int getTileSize(){
        return tileSize;
    }
}
