package com.back;

import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String ars[]) {

        Scanner sc = new Scanner(System.in);
        int id = 0;
        List<wiseSaying> list = new ArrayList<>();
        System.out.println("==명언 앱==");


        while (true) {
            System.out.print("명령)");
            String ans = sc.nextLine();
            if (ans.equals("종료")) { // 종료 입력 시
                break;
            }
            else if (ans.equals("등록")) { // 등록 입력 시
                System.out.printf("명언 : ");
                String content = sc.nextLine();
                System.out.printf("작가 : ");
                String author = sc.nextLine();
                id++;
                System.out.println(id + "번 명언이 등록되었습니다.");
                list.add(new wiseSaying(id, author, content));

            }
            else if (ans.equals("목록")) { // 목록 입력 시
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = list.size() - 1; i >= 0; i--) {
                    wiseSaying ws = list.get(i);
                    System.out.println(ws.id + " / " + ws.author + " / " + ws.content);

                }

            }
            else if (ans.startsWith("삭제?id=")) { // 삭제 입력 시
                String[] findId = ans.split("=");
                int removeId = Integer.parseInt(findId[1]);

                boolean find = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).id == removeId) {
                        list.remove(i);
                        System.out.println(removeId + "번 명언이 삭제되었습니다.");
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    System.out.println(removeId + "번 명언은 존재하지 않습니다.");
                }
            }
            else if (ans.startsWith("수정?id=")) { // 수정 입력 시
                String[] findId = ans.split("=");
                int editId = Integer.parseInt(findId[1]);

                boolean find = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).id == editId) {
                        wiseSaying ws = list.get(i);

                        System.out.println("명언(기존) : " + ws.content);
                        System.out.print("명언 : ");
                        ws.content = sc.nextLine();
                        System.out.println("작가(기존) : " + ws.author);
                        System.out.print("작가 : ");
                        ws.author = sc.nextLine();
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    System.out.println(editId + "번 명언은 존재하지 않습니다.");
                }

            } else {
                System.out.println("명령을 다시 입력해주세요.");
            }
        }
    }
}

class wiseSaying {

    int id;
    String author;
    String content;

    public wiseSaying(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }
}