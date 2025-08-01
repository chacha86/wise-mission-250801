package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wiseSayings = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                wsRegister(sc, wiseSayings);
            } else if (command.equals("목록")) {
                wsList(wiseSayings);
            } else if (command.startsWith("삭제?id=")) {
                wsDelete(command, wiseSayings);
            } else if (command.startsWith("수정?id=")) {
                wsModify(command, sc, wiseSayings);
            } else {
                System.out.println("잘못된 명령입니다.");
            }
        }
        sc.close();
    }

    private static void wsRegister(Scanner sc, List<WiseSaying> list) {
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying ws = new WiseSaying(content, author);
        list.add(ws);
        System.out.println(ws.id + "번 명언이 등록되었습니다.");
    }

    private static void wsList(List<WiseSaying> list) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = list.size() - 1; i >= 0; i--) {
            WiseSaying ws = list.get(i);
            System.out.println(ws.id + " / " + ws.author + " / " + ws.content);
        }
    }

    private static void wsDelete(String command, List<WiseSaying> list) {
        int id = parseId(command);

        if (id == -1) {
            System.out.println("잘못된 명령입니다.");
            return;
        }

        WiseSaying ws = findById(list, id);
        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            list.remove(ws);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
    }

    private static void wsModify(String command, Scanner sc, List<WiseSaying> list) {
        int id = parseId(command);

        if (id == -1) {
            System.out.println("잘못된 명령입니다.");
            return;
        }

        WiseSaying ws = findById(list, id);
        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println("명언(기존) : " + ws.content);
            System.out.print("명언 : ");
            String newContent = sc.nextLine();

            System.out.println("작가(기존) : " + ws.author);
            System.out.print("작가 : ");
            String newAuthor = sc.nextLine();

            ws.content = newContent;
            ws.author = newAuthor;
            System.out.println(id + "번 명언이 수정되었습니다.");
        }
    }

    private static WiseSaying findById(List<WiseSaying> list, int id) {
        for (WiseSaying ws : list) {
            if (ws.id == id) {
                return ws;
            }
        }
        return null;
    }

    private static int parseId(String command) {
        String[] parts = command.split("=");
        if (parts.length != 2) return -1;

        try {
            return Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}