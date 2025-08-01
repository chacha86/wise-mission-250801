package com.back;

public class WiseSaying {
    private static int counter = 0;
    int id;
    String content;
    String author;

    public WiseSaying(String content, String author) {
        counter++;
        this.id = counter;
        this.content = content;
        this.author = author;
    }
}
