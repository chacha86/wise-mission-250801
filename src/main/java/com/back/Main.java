package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        int[] ids = new int[100];             // 번호 저장용
        String[] contents = new String[100];  // 명언 저장용
        String[] authors = new String[100];   // 작가 저장용
        int count = 0;        // 현재까지 등록된 개수
        int lastId = 1;       // 마지막으로 부여된 ID

        while (true) {
            System.out.print("명령) ");
            String input = scanner.nextLine();

            if (input.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                ids[count] = lastId;
                contents[count] = content;
                authors[count] = author;

                System.out.println(lastId + "번 명언이 등록되었습니다.");

                count++;
                lastId++;
            }

            else if (input.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------------------");

                for (int i = count - 1; i >= 0; i--) {
                    if (contents[i] != null) {
                        System.out.printf("%d / %s / %s\n", ids[i], authors[i], contents[i]);
                    }
                }
            }

            else if (input.startsWith("삭제?id=")) {
                try {
                    int id = Integer.parseInt(input.substring(8).trim());

                    int foundIndex = -1;

                    for (int i = 0; i < count; i++) {
                        if (ids[i] == id && contents[i] != null) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex == -1) {
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                    } else {
                        contents[foundIndex] = null;
                        authors[foundIndex] = null;
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID 형식이 잘못되었습니다.");
                }
            }else if (input.startsWith("수정?id=")) {
                try {
                    int id = Integer.parseInt(input.substring(8).trim());

                    int foundIndex = -1;

                    for (int i = 0; i < count; i++) {
                        if (ids[i] == id && contents[i] != null) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex == -1) {
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                    } else {
                        System.out.println("명언(기존) : " + contents[foundIndex]);
                        System.out.print("명언 : ");
                        contents[foundIndex] = scanner.nextLine();

                        System.out.println("작가(기존) : " + authors[foundIndex]);
                        System.out.print("작가 : ");
                        authors[foundIndex] = scanner.nextLine();

                        System.out.println(id + "번 명언이 수정되었습니다.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("ID 형식이 잘못되었습니다.");
                }
            }
            else if (input.equals("종료")) {
                break;
            }
        }
    }
}