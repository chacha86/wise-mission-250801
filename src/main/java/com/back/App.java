package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    List<Saying> sayingList = new ArrayList<>();
    int no = 0;
    public static class Saying {
        private int id; // 번호
        private String content;  // 명언
        private String author;  // 작가

        public Saying(int id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }

        public int getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print(" 명령 ) ");
            String command = sc.nextLine();
            switch(command) {
                case "종료":
                    return;
                case "등록":
                    Saying saying = register();
                    sayingList.add(saying);
                    System.out.println(saying.id + "번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    list();
                    break;
                case "수정":
                    System.out.print(" 수정?id=");
                    int modifyId = sc.nextInt();
                    sc.nextLine();  // 버퍼 비우기
                    modify(modifyId);
                    break;
                case "삭제":
                    System.out.print(" 삭제?id=");
                    int removeId = sc.nextInt();
                    sc.nextLine();  // 버퍼 비우기
                    remove(removeId);
                    break;
            }
        }
    }

    private Saying register(){    // 등록
        System.out.print(" 명언 : ");
        String content = sc.nextLine();

        System.out.print(" 작가 : ");
        String author = sc.nextLine();

        no++;
        return new Saying(no, content, author);
    }

    private void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = sayingList.size()-1; i >= 0; i--) {
            Saying saying = sayingList.get(i);
            System.out.println(saying.getId() + " / " + saying.getAuthor() + " / " + saying.getContent());
        }
    }

    private void remove(int removeId) {   // 삭제

        boolean isRemoved = sayingList.removeIf(saying -> saying.getId() == removeId);

        if (isRemoved) {
            System.out.println(removeId + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(removeId + "번 멍언은 존재하지 않습니다.");
        }
    }

    private void modify(int modifyId) {   // 수정
        Optional<Saying> foundSaying = sayingList.stream()
                .filter(saying -> saying.getId() == modifyId)
                .findFirst();

        if (foundSaying.isPresent()) {
            Saying sayingToModify = foundSaying.get();
            System.out.println(" 명언(기존) : " + sayingToModify.getContent());
            System.out.print(" 명언 : ");
            String content = sc.nextLine();
            sayingToModify.setContent(content);
            System.out.print(" 작가 : ");
            String author = sc.nextLine();
            sayingToModify.setAuthor(author);

        } else {
            System.out.println(modifyId + "번 명언은 존재하지 않습니다.");
        }
    }
}
