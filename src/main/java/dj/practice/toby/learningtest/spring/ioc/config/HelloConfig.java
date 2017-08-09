package dj.practice.toby.learningtest.spring.ioc.config;

import dj.practice.toby.learningtest.spring.ioc.bean.AnnotatedHello;
import dj.practice.toby.learningtest.spring.ioc.bean.Hello;
import dj.practice.toby.learningtest.spring.ioc.bean.Printer;
import dj.practice.toby.learningtest.spring.ioc.bean.StringPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {
    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName("Spring");
        hello.setPrinter(printer());
        return hello;
    }

    @Bean
    public Hello hello2() {
        Hello hello = new Hello();
        hello.setName("Spring2");
        hello.setPrinter(printer());
        return hello;
    }

    @Bean
    public Printer printer(){
        return new StringPrinter();
    }
}
