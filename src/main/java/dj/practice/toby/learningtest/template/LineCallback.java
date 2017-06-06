package dj.practice.toby.learningtest.template;

/**
 * Created by Dongjoon on 2017. 6. 6..
 */
public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
