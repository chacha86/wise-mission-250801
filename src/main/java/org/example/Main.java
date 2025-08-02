package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WiseSaying {
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
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<WiseSaying> list = new ArrayList<>();
        int number = 0;
        String author;
        String content;
        String input;


        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            input =  sc.nextLine();

            if (input.equals("등록")) {
                System.out.print("명언 : ");
                content = sc.nextLine();
                System.out.print("작가 : ");
                author = sc.nextLine();
                System.out.println(++number + "번 명언이 등록되었습니다.");

                list.add(new WiseSaying(number, author, content)); // 여기서 객체 생성
            } else if (input.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = list.size() - 1; i >= 0; i--) {
                    list.get(i).up();
                }

            } else if (input.startsWith("삭제?id=")) {
                String idStr = input.substring("삭제?id=".length());  // "1"
                int id = Integer.parseInt(idStr);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getNumber() == id) {
                        list.remove(i);
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                    }
                }
            } else {
                break;
            }
        }
    }
}