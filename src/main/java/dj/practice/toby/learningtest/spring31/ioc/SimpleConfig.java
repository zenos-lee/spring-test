package dj.practice.toby.learningtest.spring31.ioc;

import dj.practice.toby.learningtest.spring.ioc.bean.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {
    @Autowired
    Hello hello;

    @Bean
    Hello hello() {
        return new Hello();
    }
}
