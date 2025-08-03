package com.back;

public class WiseSayingDto {
    private int number;
    private String author;
    private String wiseSaying;

    public WiseSayingDto(int number, String author, String wiseSaying) {
        this.number = number;
        this.author = author;
        this.wiseSaying = wiseSaying;
    }

    public int GetNumber() {
        return this.number;
    }

    public String GetAuthor() {
        return this.author;
    }

    public String GetWiseSaying() {
        return this.wiseSaying;
    }
}
