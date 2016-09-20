package Entity;

import Input.KeyInput;
import Main.Board;
import Sprite.Sprite;
import Sprite.SpriteSheet;
import TileMap.TileMap;
import Utils.TextureAtlas;
import Sprite.Animation;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

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


    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;


    private TileMap tileMap;
    private TextureAtlas atlas;
    private SpriteSheet sheet;
    private Sprite sprite;

    //Рисунок движений по сторонам
    private  SpriteSheet sheetUP;
    private  SpriteSheet sheetDown;
    private  SpriteSheet sheetLeft;
    private  SpriteSheet sheetRight;

    private Animation animation;

    //ArraySprites move
    private  BufferedImage [] upMove ;
    private  BufferedImage [] downMove ;
    private  BufferedImage [] leftMove ;
    private  BufferedImage [] rightMove ;

    private int curFrame = 0;

    public Heroy(TileMap tileMap){
        this.atlas = atlas;
        this.tileMap = tileMap;

        init();

    }

    public void init(){
        atlas = new TextureAtlas("images/playerSprite.png");
        sheet = new SpriteSheet(atlas.cut(0, 0, 96 ,128),12,32);
         sheetUP = new SpriteSheet(atlas.cut(0, 96, 96 ,32),3,32);
         upMove = new BufferedImage[]{
                 sheetUP.getSprite(0),
                 sheetUP.getSprite(1),
                 sheetUP.getSprite(2)};

        sheetDown = new SpriteSheet(atlas.cut(0,0,96,32),3,32);
        downMove = new BufferedImage[]{
                sheetDown.getSprite(0),
                sheetDown.getSprite(1),
                sheetDown.getSprite(2)};

        sheetLeft = new SpriteSheet(atlas.cut(0,32,96,32),3,32);
        leftMove = new BufferedImage[]{
                sheetLeft.getSprite(0),
                sheetLeft.getSprite(1),
                sheetLeft.getSprite(2)};

        sheetRight = new SpriteSheet(atlas.cut(0,64,96,32),3,32);
        rightMove = new BufferedImage[]{
                sheetRight.getSprite(0),
                sheetRight.getSprite(1),
                sheetRight.getSprite(2)};
        animation = new Animation();

    }
    public void tick(){
        handleInput();
        if(left){
            animation.setFrame(leftMove);
            animation.setDelay(100);
        }
        if(right){
            animation.setFrame(rightMove);
            animation.setDelay(100);
        }
        if(up){
            animation.setFrame(upMove);
            animation.setDelay(100);
        }
        if(down){
            animation.setFrame(downMove);
            animation.setDelay(100);
        }
        animation.tick();

    }

    //Движение сущности
    public void handleInput(){

        if(KeyInput.keys[KeyEvent.VK_LEFT]) {
            left = true;
            x-=3;
        }else left = false;
        if(KeyInput.keys[KeyEvent.VK_RIGHT]) {
            right = true;
            x+=3;
        }else right = false;
        if(KeyInput.keys[KeyEvent.VK_UP]) {
            up = true;
            y-=3;
        }else up = false;
        if(KeyInput.keys[KeyEvent.VK_DOWN]) {
            down = true;
            y+=3;
        }else down = false;



    }


    public  void render(Graphics g) {
        g.drawImage(animation.getImage(),(int)x,(int)y,null);


        //sprite.render(g,120,120);

       // g.setColor(Color.red);
       // g.drawImage(atlas.cut(0,0,32,32),(int)(tx + x - width /2),(int)(ty +y - width/2),width,height,null);
        //g.fillRect((int)(tx + x - width /2),(int)(ty + y -width /2),width,height);

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
}
