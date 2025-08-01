package com.back;

import java.util.*;

public class Main {
    static class Quote {
        int id;
        String content;
        String author;

        Quote(int id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Quote> quotes = new ArrayList<>();
        int lastId = 0;

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine().trim();

                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                lastId++;
                quotes.add(new Quote(lastId, content, author));
                System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);
            }
            else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = quotes.size() - 1; i >= 0; i--) {
                    Quote q = quotes.get(i);
                    System.out.printf("%d / %s / %s\n", q.id, q.author, q.content);
                }
            }
            else if (cmd.startsWith("삭제?id=")) {
                try {
                    int id = Integer.parseInt(cmd.split("=")[1]);
                    Quote target = null;
                    for (Quote q : quotes) {
                        if (q.id == id) {
                            target = q;
                            break;
                        }
                    }
                    if (target != null) {
                        quotes.remove(target);
                        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                    } else {
                        System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 명령 형식입니다.");
                }
            }
            else if (cmd.startsWith("수정?id=")) {
                try {
                    int id = Integer.parseInt(cmd.split("=")[1]);
                    Quote target = null;
                    for (Quote q : quotes) {
                        if (q.id == id) {
                            target = q;
                            break;
                        }
                    }
                    if (target != null) {
                        System.out.printf("명언(기존) : %s\n", target.content);
                        System.out.print("명언 : ");
                        String newContent = sc.nextLine().trim();
                        target.content = newContent;

                        System.out.printf("작가(기존) : %s\n", target.author);
                        System.out.print("작가 : ");
                        String newAuthor = sc.nextLine().trim();
                        target.author = newAuthor;
                    } else {
                        System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 명령 형식입니다.");
                }
            }
        }
    }
}