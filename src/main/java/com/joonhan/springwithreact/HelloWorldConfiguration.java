package com.joonhan.springwithreact;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) { };

record Address (String firstLine, String city) { };

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "joonhan";
    }

    @Bean
    public int age() {
        return 42;
    }

    @Bean
    public Person person() {
        return new Person("hanjoon", 24, new Address("Main street", "Utrecht"));
    }

    @Bean
    public Person person2MethodCall() {
        // 기존에 존재하는 Bean 을 이용해서 새로운 Bean 을 생성하는 것도 가능
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        // 매개변수로 받으면 아래와 같이 사용 가능. Bean 객체의 이름이 변수 이름이 됨.
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        // 매개변수로 받으면 아래와 같이 사용 가능. Bean 객체의 이름이 변수 이름이 됨.
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
        // 매개변수로 받으면 아래와 같이 사용 가능. Bean 객체의 이름이 변수 이름이 됨.
        return new Person(name, age, address);
    }

    // Bean 객체 이름을 임의로 지정할 수 있다.
    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("Seoul", "Gangnam");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Gyeonggi", "Goyang");
    }

}
