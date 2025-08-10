package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    List<String> wiseSayings = new ArrayList();
    List<String> authors = new ArrayList();
    List<Integer> numbers = new ArrayList();
    int no = 1;

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("등록")) {
                actionWrite();

            } else if (command.equals("목록")) {
                actionList();

            } else if (command.startsWith("삭제")) {
                actionDelete(command);

            } else if (command.startsWith("수정")) {
                actionModify(command);

            } else if (command.equals("종료")) {
                break;
            }
        }
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        wiseSayings.add(saying);
        System.out.print("작가 : ");
        String author = sc.nextLine();
        authors.add(author);
        numbers.add(no);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(no));
        no++;
    }


    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            System.out.println("%s / %s / %s".formatted(numbers.get(i), authors.get(i), wiseSayings.get(i)));
        }
    }

    private void actionDelete(String command) {
        int deleteId = Integer.parseInt(command.split("=")[1]);
        int noIndex = numbers.indexOf(deleteId);
        if (noIndex == -1) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteId));
        } else {
            wiseSayings.remove(noIndex);
            authors.remove(noIndex);
            numbers.remove(noIndex);
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
        }
    }


    private void actionModify(String command) {
        int modifiedId = Integer.parseInt(command.split("=")[1]);
        int noIndex = numbers.indexOf(modifiedId);
        if (noIndex == -1) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(modifiedId));
        } else {
            System.out.println("명언(기존) : %s".formatted(wiseSayings.get(noIndex)));
            System.out.print("명언 : ");
            wiseSayings.set(noIndex, sc.nextLine());
            System.out.println("작가(기존) : %s".formatted(authors.get(noIndex)));
            System.out.print("작가 : ");
            authors.set(noIndex, sc.nextLine());
        }
    }
}
