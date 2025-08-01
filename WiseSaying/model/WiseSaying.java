package com.back.WiseSaying.model;

public class WiseSaying {
    public int id;
    public Boolean isDelete = false;
    public String author = "";
    public String content = "";

    public WiseSaying() {
    }

    public WiseSaying(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }
}
