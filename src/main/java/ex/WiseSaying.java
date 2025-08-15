package ex;

import java.util.Scanner;

public class WiseSaying {
    private int number;
    private String author;
    private String content;

    public WiseSaying(int number, String author, String content) {
        this.number = number;
        this.author = author;
        this.content = content;
    }

    public void up(){
        System.out.println(number+" / " +author+" / "+content);
    }

    public int getNumber(){
        return number;
    }

    public void editWiseSaying(){
        System.out.println("명언(기존) : " + content);
        System.out.print("명언 : ");
        content = new Scanner(System.in).nextLine();

        System.out.println("작가(기존) : " + author);
        System.out.print("작가 : ");
        author = new Scanner(System.in).nextLine();
    }
}
