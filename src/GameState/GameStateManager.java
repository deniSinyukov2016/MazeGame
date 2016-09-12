package GameState;

import java.awt.*;

/**
 * Created by Denis on 02.09.2016.
 */
public class GameStateManager {

    private GameState [] gameStates;
    private GameState currentState ;

    public static final int COUNT_STATE = 5;//количесво сцен
    public static final int MENU_STATE = 0;//меню


    public GameStateManager (){

        gameStates = new GameState[COUNT_STATE];
        currentState = new MenuState(this);
       // loadState(currentState);


    }
    public void init(){
        //getState_ofNumber(currentState).init();
        currentState.init();
    }
    public void tick(){
        //getState_ofNumber(currentState).tick();
        currentState.tick();
    }
    public void render(Graphics g){
        currentState.render(g);

        //getState_ofNumber(currentState).render(g);
    }

    public void setGameStates(GameState states){
        currentState = states;
    }


//    private GameState loadState(int state) {
//        if(currentState == MENU_STATE){
//            gameStates[state] = new MenuState(this);
//        }
//        return gameStates[state];
//    }

    //возвращает State по его номеру
    public GameState getState_ofNumber(int state){
        return gameStates[state];
    }

}
