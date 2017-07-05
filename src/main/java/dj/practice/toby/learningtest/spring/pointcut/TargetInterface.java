package dj.practice.toby.learningtest.spring.pointcut;

/**
 * Created by Dongjoon on 2017. 7. 5..
 */
public interface TargetInterface {
    public void hello();
    public void hello(String a);
    public int minus(int a, int b) throws RuntimeException;
    public int plus(int a, int b);
}
