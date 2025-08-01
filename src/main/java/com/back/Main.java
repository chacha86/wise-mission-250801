package com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {  //프로그램의 시작점
        ArrayList<Quote> quotes = new ArrayList<>(); //이런식으로 리스트를 선언할수 있다.
        Scanner sc = new Scanner(System.in);
        int id = 1; //id는 1부터 시작
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String line = sc.nextLine(); //한 줄 입력
            switch (line) {
                case "종료":
                    return;

                case "등록":
                    System.out.print("명언 : ");  
                    String content = sc.nextLine();    //명언 입력
                    System.out.print("작가 : ");
                    String author = sc.nextLine();    //작가 입력
                    quotes.add(new Quote(id, content, author));  //리스트에 Quote 객체 추가
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    id++; //id는 삭제되도 다시 쓰이지 않으므로 ++
                    break;

                case "목록":
                    for (Quote q : quotes) {
                        q.print();

                    }
                    break;

                case "삭제":
                    System.out.print("삭제?id=");
                    String deleteId = sc.nextLine();  //삭제 id 입력
                    Quote found = null;
                    int num = Integer.parseInt(deleteId);
                    for (int i = 0; i < quotes.size(); i++) {
                        if (quotes.get(i).id == num) {  
                            found = quotes.get(i); //arrayList의 get함수로 접근해 저장해놓음
                            quotes.remove(i);
                            System.out.println(num + "번 명언이 삭제되었습니다.");
                            break;

                        }

                    }
                    if (found == null) {     //명언 존재 여부 확인
                        System.out.println(num + "번 명언은 존재하지 않습니다.");

                    }
                    break;

                case "수정":
                    System.out.print("수정?id=");
                    String editId = sc.nextLine();
                    Quote found1 = null;
                    int num1 = Integer.parseInt(editId);

                    for (int i = 0; i < quotes.size(); i++) {
                        if (quotes.get(i).id == num1) {
                            found1 = quotes.get(i);
                            break;

                        }

                    }

                    if (found1 == null) {  //명언 존재 여부 확인
                        System.out.println(editId + "번 명언은 존재하지 않습니다.");
                    } else {
                        System.out.println("명언(기존) : " + found1.content);
                        System.out.print("명언: ");
                        String newContent = sc.nextLine();

                        System.out.println("작가(기존) : " + found1.author);
                        System.out.print("작가: ");
                        String newAuthor = sc.nextLine();

                        found1.content = newContent;
                        found1.author = newAuthor;

                        found1.print();
                    }
            }

        }
    }
}


class Quote {
    int id;   //id
    String content; //명언
    String author; //작가

    public Quote(int id, String content, String author) {  //생성자
        this.id = id;       
        this.content = content;
        this.author = author;
    }

    public void print() { //출력 메서드
        System.out.println(id + " / " + content + " / " + author);
    }


}
