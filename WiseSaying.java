package com.back;

public class WiseSaying {
    private boolean isDeleted = false;
    private int num;
    private String author;
    private String wiseSaying;

    public WiseSaying(int num, String author, String wiseSaying) {
        this.num = num;
        this.author = author;
        this.wiseSaying = wiseSaying;
    }

    public String contentPrint() {
        return num + "  /   " + author + "   /   " + wiseSaying;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public int getNum() {
        return num;
    }

    public String getAuthor() {
        return author;
    }

    public String getWiseSaying() {
        return wiseSaying;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setWiseSaying(String wiseSaying) {
        this.wiseSaying = wiseSaying;
    }

    public void setDeleted() {
        isDeleted = true;
    }


}
