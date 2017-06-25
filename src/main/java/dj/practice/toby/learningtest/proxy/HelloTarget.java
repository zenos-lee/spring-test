package dj.practice.toby.learningtest.proxy;

/**
 * Created by Dongjoon on 2017. 6. 25..
 */
public class HelloTarget implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayHi(String name) {
        return "Hi " + name;
    }

    @Override
    public String sayThankYou(String name) {
        return "Thank You " + name;
    }
}
