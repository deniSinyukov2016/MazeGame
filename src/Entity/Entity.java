package Entity;

import java.awt.*;

/**
 * Created by Denis on 03.09.2016.
 */
public abstract class Entity {

   // Расположениие сущности
    private float x ;
    private float y ;

    //Тип
    public  final EntityType entityType;

    public Entity(EntityType entityType, float x, float y){
        this.entityType = entityType;
        this.x = x;
        this.y = y;

    }

    public abstract void init();
    public abstract void render(Graphics g);
    public abstract void tick();
    public abstract void handleInput();
}
