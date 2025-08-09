package org.example.domain.wiseSaying;

import org.example.domain.wiseSaying.controller.SystemController;
import org.example.domain.wiseSaying.controller.WiseSayingController;
import org.example.domain.wiseSaying.golbal.AppContext;
import org.example.domain.wiseSaying.golbal.Rq;

import java.util.Scanner;

public class App {

    private Scanner sc = AppContext.sc;

    private SystemController systemController = AppContext.systemController;
    private WiseSayingController wiseSayingController = AppContext.wiseSayingController;
    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            Rq rq = new Rq(command);
            String actionName = rq.getActionName();
            if (actionName.equals("등록")) {
                wiseSayingController.actionWrite();

            } else if (actionName.equals("목록")) {
                wiseSayingController.actionList();

            } else if (actionName.startsWith("삭제")) {
                wiseSayingController.actionDelete(rq);

            } else if (actionName.startsWith("수정")) {
                wiseSayingController.actionModify(rq);

            } else if (actionName.equals("종료")) {
                systemController.exit();


                break;
            }
        }
    }


}