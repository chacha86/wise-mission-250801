package com.back;

public class WiseSaying {
    private String saying; //명언
    private String author;  //작가
    private int id;  //등록 번호

    public WiseSaying(int id, String saying, String author) {
        this.saying = saying;
        this.author = author;
        this.id = id;
    }
    //
    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}