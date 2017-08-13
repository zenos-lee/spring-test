package dj.practice.toby.learningtest.spring.ioc.bean;

import javax.annotation.PostConstruct;

public class Hello {
    String name;
    Printer printer;

    @PostConstruct
    public void init() {
        System.out.println("Init");
    }

    public Hello(){}

    public Hello(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

    public String sayHello() {
        return "Hello " + name;
    }

    public void print() {
        this.printer.print(sayHello());
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrinter(Printer printer){
        this.printer = printer;
    }

}
