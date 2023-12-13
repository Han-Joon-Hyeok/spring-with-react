package com.joonhan.springwithreact;

import com.joonhan.springwithreact.game.GameRunner;
import com.joonhan.springwithreact.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext
                (GamingConfiguration.class)) {


            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();

        }
    }
}
