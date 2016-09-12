package Entity;

import Input.KeyInput;
import Main.Board;
import TileMap.TileMap;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Denis on 09.09.2016.
 */
public class Heroy {

    private double x;
    private double y;
    private double dx;
    private double dy;

    private int width;
    private int height;

    private boolean left;
    private boolean right;
    private boolean jumping;
    private boolean falling;
    private  boolean topLeft;
    private  boolean topRigth;
    private  boolean bottomLeft;
    private  boolean bottomRigth;

    private double maxSpeed;
    private double moveSpeed;
    private double maxFallingSpeed;
    private double stopSpeed;
    private double jumpingStart;
    private double gravity;

    private TileMap tileMap;

    public Heroy(TileMap tileMap){
        this.tileMap = tileMap;

        width = 20;
        height = 20;

        moveSpeed = 0.6;
        maxSpeed = 4.2;
        maxFallingSpeed = 12;
        stopSpeed = 0.30;
        jumpingStart = -11.0;
        gravity = 0.64;
    }

    public  void setLeft(boolean b){
        left = b;
    }
    public void  setRight(boolean b){
        right = b;
    }
    public  void  setJumping(boolean b){
        if(!falling){
            jumping = true;
        }

    }

    public  double getX(){
        return  x;
    }

    public double getY(){
     return y;
    }
    public  void setX(int x){
        this.x = x;
    }
    public  void setY(int y){
        this.y = y;
    }


    public void tick(){
        handleInput();
        if(left) {
            dx -= moveSpeed;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        }else if(right){
            dx+=moveSpeed;
            if(dx > maxSpeed){
                dx =  maxSpeed;
            }
        }
        else {
            if(dx > 0){
                dx -= stopSpeed;
                if (dx < 0) {
                    dx = 0;
                }
            } else if (dx < 0) {
                    dx += stopSpeed;
                    if (dx > 0) {
                        dx = 0;
                    }
                }
            }

            if(jumping){
                dy = jumpingStart;
                falling = true;
                jumping = false;
            }

            if(falling){
                dy += gravity;
                if(dy > maxFallingSpeed){
                    dy = maxFallingSpeed;
                }
            }
            else {
                dy = 0;
            }

            //Check Collision
        int curCol = tileMap.getColTile((int)x);
        int curRow = tileMap.getRowTile((int)y);

        double tOX = x + dx;
        double tOY = y + dy;

        double tenpX = x;
        double tempY = y;

        calculateCorner(x, tOY);
        if(dy < 0){
            if(topLeft || topRigth){
                dy = 0;
                tempY = curRow * tileMap.getTileSize() + height /2;
            }else {
                tempY += dy;
            }
        }
        if(dy > 0){
            if(bottomLeft || bottomRigth){
                dy = 0;
                falling = false;
                tempY = (curRow + 1) * tileMap.getTileSize() - height /2;
            }else{
                tempY +=dy;
            }
        }
        calculateCorner(tOX, y);
        if(dx < 0){
            if(topLeft || bottomLeft){
                dx = 0;
                tenpX = curCol * tileMap.getTileSize() + width /2;
            }else {
                tenpX +=dx;
            }
        }
        if (dx > 0){
            if(topRigth || bottomRigth){
                dx = 0;
                tenpX = (curCol +1) * tileMap.getTileSize() - width /2;
            }else{
                tenpX += dx;
            }
        }
        if(!falling){
            calculateCorner(x, y + 1);
            if(!bottomLeft && !bottomRigth){
                falling = true;
            }
        }
        x = tenpX;
        y = tempY;
        tileMap.setX((int)(Board.WIDTH /2 - x));
        tileMap.setY((int)(Board.HEIGTH /2 - y));
    }

    private void calculateCorner(double x, double y) {
    int lefTile = tileMap.getColTile((int)(x - width / 2));
    int rigthTile = tileMap.getColTile((int)(x + width / 2));
    int topTile = tileMap.getColTile((int)(y - height / 2));
    int bottomTile = tileMap.getColTile((int)(y + height / 2));
        topLeft = tileMap.getTile(topTile,lefTile) == 0;
        topRigth = tileMap.getTile(topTile,rigthTile) == 0;
        bottomLeft = tileMap.getTile(bottomTile,lefTile) == 0;
        bottomRigth = tileMap.getTile(bottomTile,rigthTile) == 0;
    }


    //Движение сущности
    public void handleInput(){

    }


    public  void render(Graphics g){

        int tx = tileMap.getX();
        int ty = tileMap.getY();

        g.setColor(Color.red);
        g.fillRect((int)(tx + x - width /2),(int)(ty + y -width /2),width,height);

    }
}
