package com.joonhan.springwithreact;

import com.joonhan.springwithreact.game.GameRunner;
import com.joonhan.springwithreact.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        /*

        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);

         */

//        var game = new MarioGame();
        var game = new SuperContraGame();
        var gameRunner = new GameRunner(game);

        gameRunner.run();

    }
}
