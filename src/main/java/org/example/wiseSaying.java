package org.example;

import java.util.Scanner;

public class wiseSaying {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        String str = "";
        int count = 1;
        String[][] book = new String[1000][3];

        while (!str.equals("종료")) {
            System.out.print("명령) ");
            str = scanner.nextLine();
            if (str.equals("등록")) {
                System.out.print("명언 : ");
                String ws = scanner.nextLine();
                System.out.print("작가 : ");
                String auth = scanner.nextLine();
                book[count][0] = Integer.toString(count);
                book[count][1] = auth;
                book[count][2] = ws;
                System.out.println(count + "번 명언이 등록되었습니다.");
                count++;
            } else if (str.equals("목록")) {
                System.out.println("번호 / 작가 / 명언  ");
                System.out.println("------------------------");
                for (int i = count - 1; i > 0; i--) {
                    for (int j = 0; j < book[i].length; j++) {
                        if (book[i][0] == null) continue;
                        else if (j != 2) System.out.print(book[i][j] + " / ");
                        else System.out.print(book[i][j]);
                    }
                    System.out.println();
                }
            } else if (str.startsWith("삭제?id=")) {
                int delNum = Integer.parseInt(str.substring(6));
                if (delNum <= 0 || delNum >= count || book[delNum][0] == null) {
                    System.out.println(delNum + "번 명언은 존재하지 않습니다.");
                } else {
                    book[delNum][0] = null;
                    book[delNum][1] = null;
                    book[delNum][2] = null;
                    System.out.println(delNum + "번 명언이 삭제되었습니다.");
                }
            } else if (str.startsWith("수정?id=")) {
                int altNum = Integer.parseInt(str.substring(6));
                if (altNum <= 0 || altNum >= count || book[altNum][0] == null) {
                    System.out.println(altNum + "번 명언은 존재하지 않습니다.");
                } else {
                    System.out.println("명언(기존) : " + book[altNum][2]);
                    System.out.print("명언 : ");
                    String altws = scanner.nextLine();
                    book[altNum][2] = altws;
                    System.out.println("작가(기존) : " + book[altNum][1]);
                    System.out.print("작가 : ");
                    String altauth = scanner.nextLine();
                    book[altNum][1] = altauth;
                }
            }
        }
    }
}

