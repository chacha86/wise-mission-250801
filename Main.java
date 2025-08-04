package com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int no = 1;
    static ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("등록")) {
                wiseSayingRegister();

            } else if (command.equals("목록")) {
                wiseSayingList(wiseSayings);

            } else if (command.startsWith("삭제?id=")) {
                wiseSayingDelete(command);

            } else if (command.startsWith("수정?id=")) {
                wiseSayingModify(command);

            } else if (command.equals("종료")) {
                break;
            }
        }
    }

    public static void wiseSayingRegister() {
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayings.add(new WiseSaying(no, author, content));
        System.out.println(no + "번 명언이 등록되었습니다.");
        no++;
    }

    public static void wiseSayingList(ArrayList<WiseSaying> wiseSayings) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayings.get(i);
            System.out.println(ws.id + " / " + ws.author + " / " + ws.content);
        }
    }

    public static void wiseSayingDelete(String command) {
        String idPart = command.substring("삭제?id=".length());
        int targetId = Integer.parseInt(idPart);

        boolean removed = wiseSayings.removeIf(ws -> ws.id == targetId);

        if (removed) {
            System.out.println(targetId + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(targetId + "번 명언은 존재하지 않습니다.");
        }
    }

    public static void wiseSayingModify(String command) {
        String idPart = command.substring("수정?id=".length());
        int targetId = Integer.parseInt(idPart);

        boolean found = false;

        for (WiseSaying ws : wiseSayings) {
            if (ws.id == targetId) {
                System.out.println("명언(기존) : " + ws.content);
                System.out.print("명언 : ");
                String newContent = sc.nextLine();

                System.out.println("작가(기존) : " + ws.author);
                System.out.print("작가 : ");
                String newAuthor = sc.nextLine();

                ws.content = newContent;
                ws.author = newAuthor;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(targetId + "번 명언이 존재하지 않습니다.");
        }
    }
}
