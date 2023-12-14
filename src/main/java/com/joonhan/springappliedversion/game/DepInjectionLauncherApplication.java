package com.joonhan.springappliedversion.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
    /*

        1. 필드 인젝션 (not recommended)

        @Autowired
        Dependency1 dependency1;

        @Autowired
        Dependency2 dependency2;

     */


    /*

        2. setter 인젝션

        Dependency1 dependency1;

        Dependency2 dependency2;

        @Autowired
        public void setDependency1(Dependency1 dependency1) {
            System.out.println("Setter Injection - Dependency1");
            this.dependency1 = dependency1;
        }

        @Autowired
        public void setDependency2(Dependency2 dependency2) {
            System.out.println("Setter Injection - Dependency2");
            this.dependency2 = dependency2;
        }

     */


    // 3. 생성자 Injection (Recommended)
    Dependency1 dependency1;

    Dependency2 dependency2;

    @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Dependency 1: " + dependency1 + " Dependency 2: " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}


@Configuration
@ComponentScan("com.joonhan.springappliedversion.game")
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext
                (DepInjectionLauncherApplication.class)) {

            System.out.println(context.getBean(YourBusinessClass.class));

        }
    }
}
