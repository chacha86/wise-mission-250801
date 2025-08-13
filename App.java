package com.back;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    WiseSayingController wiseSayingController = new WiseSayingController();

    void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("등록")) {

                wiseSayingController.actionWrite();

            } else if (command.equals("목록")) {

                wiseSayingController.actionList();

            } else if (command.startsWith("삭제")) {

                Rq rq = new Rq(command);
                wiseSayingController.actionDelete(rq);

            } else if (command.startsWith("수정")) {

                Rq rq = new Rq(command);
                wiseSayingController.actionModify(rq);

            } else if (command.equals("종료")) {

                break;
            }

        }
    }
}
