package Sprite;

import java.awt.image.BufferedImage;

/**
 * Created by Denis on 20.09.2016.
 */
public class Animation {

    private BufferedImage [] frame = new BufferedImage[3];
    private int currentFrame;

    private long startTime;
    private long delay;

    public Animation (){

    }

    public void setFrame(BufferedImage [] frame){
        this.frame = frame;
        if(currentFrame >= frame.length) currentFrame = 0;
    }

    public void setDelay(long delay){
        this.delay = delay;
    }

    public void tick(){
        if(delay == -1) return;
        long elepsed = (System.nanoTime() - startTime) / 1000000;
        if(elepsed > delay){
            currentFrame++;
            startTime = System.nanoTime();
        }
        if(currentFrame == frame.length) currentFrame = 0;
    }

    public  BufferedImage getImage(){
        return  frame[currentFrame];
    }
}
