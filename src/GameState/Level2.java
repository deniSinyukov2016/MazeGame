package GameState;

import Main.Board;
import TileMap.Tile;
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

    //размер тайла
    public static final  int TILE_SCALE = 32;

    //Оригинальный размер тайла
    public static final int TILE_IN_GAME_SCALE = 1;


    public static final int SCALED_GAME_SIZE = TILE_SCALE * TILE_IN_GAME_SCALE;

    // количество тайлов в ширину
    public static final int TILE_IN_WIDTH = Board.WIDTH / SCALED_GAME_SIZE;

    //количество тайлов в высоту
    public static final int TILE_IN_HEIGHT = Board.HEIGTH / SCALED_GAME_SIZE;

    //карта
    private Integer [][]map;

    private Map<TileType,Tile> tiles ;
    private TextureAtlas atlas;


    public Level2(GameStateManager gsm) {
        super(gsm);
        //инициализация данных
        init();

    }

    @Override
    public void init() {

        map = new Integer[TILE_IN_WIDTH][TILE_IN_HEIGHT];
        tiles = new HashMap<TileType,Tile>();
        atlas = new TextureAtlas("images/tile_level.png");
        tiles.put(TileType.LAND,new Tile(atlas.cut(0,0,TILE_SCALE,TILE_SCALE),TILE_IN_GAME_SCALE,TileType.LAND));
        tiles.put(TileType.STONE,new Tile(atlas.cut(0,32,TILE_SCALE,TILE_SCALE),TILE_IN_GAME_SCALE,TileType.STONE));
        tiles.put(TileType.EMPTY,new Tile(atlas.cut(128,96,TILE_SCALE,TILE_SCALE),TILE_IN_GAME_SCALE,TileType.EMPTY));

        map = Loader.loadLevev("Maps/mapLevel.txt");

    }

    @Override
    public void tick() {

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Board.WIDTH,Board.HEIGTH);

        for (int i = 0; i <map.length ; i++) {
            for (int j = 0; j <map[i].length ; j++) {
                tiles.get(TileType.getNumFromTipe(map[i][j])).render(g,i * SCALED_GAME_SIZE,j * SCALED_GAME_SIZE);
            }
        }
    }
}
