package TileMap;

/**
 * Created by Denis on 03.09.2016.
 */
public enum TileType {

    EMPTY(0),LAND(1),STONE(2);

    private int n;

    TileType(int n){
        this.n = n;
    }

    //возвращение номера тайла
    public int getNumber(){
        return  n;
    }

    //Возвращение типа тайла по его номеру
    public static TileType getNumFromTipe(int n){
        switch (n){
            case 1: return LAND;
            case 2: return STONE;
            default: return EMPTY;
        }
    }
}
