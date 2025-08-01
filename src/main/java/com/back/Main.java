package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = "";
        int idx = 1;
        WiseSaying[] ws = new WiseSaying[100];

        System.out.println("== 명언 ==");
        while (true) {
            System.out.print("명령) ");
            order = sc.nextLine().trim();

            if (order.equals("종료")) {
                break;

            } else if (order.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                ws[idx] = new WiseSaying();
                ws[idx].content = content;
                ws[idx].author = author;

                System.out.printf("%d번 명언이 등록되었습니다.\n", idx);
                idx++;

            } else if (order.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------------------");
                for (int i = 1; i < idx; i++) {
                    if (ws[i] != null) {
                        System.out.printf(i + " / " + ws[i].author + " / " + ws[i].content + "\n");
                    }
                }

            } else if (order.startsWith("삭제?id=")) {
                String[] split = order.split("=");
                int id = Integer.parseInt(split[1].trim());
                if (id > 0 && id < idx && ws[id] != null) {
                    ws[id] = null;
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                } else {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                }

            } else if (order.startsWith("수정?id=")) {
                String[] split = order.split("=");
                int id = Integer.parseInt(split[1].trim());
                if (id > 0 && id < idx && ws[id] != null) {
                    System.out.printf("명언(기존) : %s\n", ws[id].content);
                    System.out.print("명언 : ");
                    String newContent = sc.nextLine();

                    System.out.printf("작가(기존) : %s\n", ws[id].author);
                    System.out.print("작가 : ");
                    String newAuthor = sc.nextLine();

                    ws[id].content = newContent;
                    ws[id].author = newAuthor;

                    System.out.printf("%d번 명언이 수정되었습니다.\n", id);
                } else {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                }
            }
        }
    }
}

class WiseSaying {
    String content;
    String author;
}