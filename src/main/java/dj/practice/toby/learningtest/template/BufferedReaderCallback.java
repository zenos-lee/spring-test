package dj.practice.toby.learningtest.template;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Dongjoon on 2017. 6. 6..
 */
public interface BufferedReaderCallback {
    Integer doSomethingWithReader(BufferedReader br) throws IOException;
}
