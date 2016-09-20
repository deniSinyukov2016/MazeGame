package GameState;

import Entity.Heroy;
import Main.Board;
import TileMap.Tile;
import TileMap.TileMap;
import TileMap.TileType;
import Utils.Loader;
import Utils.TextureAtlas;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis on 08.09.2016.
 */
public class Level2 extends GameState {

    //Player
    private Heroy heroy;

    //Map
    private TileMap tileMap;


    public Level2(GameStateManager gsm) {
        super(gsm);
        //инициализация данных
        init();

    }

    @Override
    public void init() {
        tileMap = new TileMap();

        heroy = new Heroy(tileMap);

        //начальные координаты Player
        heroy.setX(100);
        heroy.setY(123);

    }

    @Override
    public void tick() {
        heroy.tick();

    }

    @Override
    public void handleInput() {
    }

    @Override
    public void render(Graphics g) {

        tileMap.render(g);
        heroy.render(g);
    }
}
