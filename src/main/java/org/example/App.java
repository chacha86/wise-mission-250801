package org.example;

import org.example.controller.Controller;
import org.global.AppContext;
import org.global.Rq;

import java.util.Scanner;

public class App {

    private Controller controller = AppContext.controller;
    private Scanner scanner = AppContext.scanner;

    public void run() {
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();
            Rq rq = new Rq(command);
            String actionName = rq.getActionName();
            switch (actionName) {
                case "종료" -> {
                    return;
                }
                case "등록" -> controller.write();
                case "목록" -> controller.list();
                case "삭제" -> controller.delete(rq.getQueryId());
                case "수정" -> controller.edit(rq.getQueryId());
            }
        }
    }

}
