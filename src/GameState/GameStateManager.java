package GameState;

import java.awt.*;

/**
 * Created by Denis on 02.09.2016.
 */
public class GameStateManager {

    private GameState [] gameStates;
    private int currentState ;
    private int previousState;

    public static final int COUNT_STATE = 6;//количесво сцен
   // public static final int EXIT = 2;//ЗАСТАВКА
    public static final int INTRO_STATE = 1;//выход
    public static final int MENU_STATE = 2;//меню
    public static final int PLAY_STATE = 0;//игра
    public static final int PAUSE_STATE = 3;//меню


    public GameStateManager (){

        gameStates = new GameState[COUNT_STATE];
        //currentState = new MenuState(this);
       // loadState(currentState);
        setState(2);



    }
    public void init(){
        //getState_ofNumber(currentState).init();
        //currentState.init();
    }
//    public void tick(){
//        //getState_ofNumber(currentState).tick();
//        //currentState.tick();
//    }
//    public void render(Graphics g){
//        //currentState.render(g);
//
//        //getState_ofNumber(currentState).render(g);
//    }

    public void setState(int i) {
        previousState = currentState;
        unloadState(previousState);
        currentState = i;
        if(i == INTRO_STATE) {
            gameStates[i] = new IntroState(this);
            gameStates[i].init();
        }
        else if(i == MENU_STATE) {
            gameStates[i] = new MenuState(this);
            gameStates[i].init();
        }
        else if(i == PLAY_STATE) {
            gameStates[i] = new Level2(this);
            gameStates[i].init();
        }
//        else if(i == GAMEOVER) {
//            gameStates[i] = new GameOverState(this);
//            gameStates[i].init();
//        }
    }

//    public void setGameStates(GameState states){
//        currentState = states;
//    }

    public void unloadState(int i) {
        gameStates[i] = null;
    }

//    public void setPaused(boolean b) {
//        paused = b;
//    }

    public void tick() {
//        if(paused) {
//            pauseState.update();
//        }
        if(gameStates[currentState] != null) {
            gameStates[currentState].tick();
        }
    }

    public void render(Graphics g) {
//        if(paused) {
//            pauseState.draw(g);
//        }
         if(gameStates[currentState] != null) {
            gameStates[currentState].render(g);
        }
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
