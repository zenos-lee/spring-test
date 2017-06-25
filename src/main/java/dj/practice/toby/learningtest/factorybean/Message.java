package dj.practice.toby.learningtest.factorybean;

/**
 * Created by Dongjoon on 2017. 6. 25..
 */
public class Message {
    String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Message newMessage(String text) {
        return new Message(text);
    }
}
