package com.joonhan.springwithreact;

import com.joonhan.springwithreact.game.GameRunner;
import com.joonhan.springwithreact.game.GamingConsole;
import com.joonhan.springwithreact.game.MarioGame;
import com.joonhan.springwithreact.game.SuperContraGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
    public GamingConsole game() {
//        return new MarioGame();
        return new SuperContraGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }
}
