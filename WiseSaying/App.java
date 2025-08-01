package com.back.WiseSaying;

import com.back.WiseSaying.controller.WiseSayingController;
import com.back.WiseSaying.util.ParamParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public Scanner sc = new Scanner(System.in);
    public WiseSayingController controller = new WiseSayingController();
    Map<String, Runnable> commands = new HashMap<>();
    public Map<String, String> lastParams = new HashMap<>();

    public App()
    {
        commands.put("등록", () -> controller.registerCommand(sc));
        commands.put("목록", () -> controller.showListCommand());
        commands.put("삭제", () -> {
            Map<String, String> params = lastParams;
            controller.deleteCommand(params);
        });
        commands.put("수정", ()-> {
            Map<String, String> params = lastParams;
            controller.changeCommand(params, sc);
        });
        commands.put("종료", () -> controller.exitCommand());
    }

    public void run()
    {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String orderText = sc.nextLine().trim();
            String[] orderTextParts = orderText.split("\\?");
            String action = orderTextParts[0];
            lastParams = ParamParser.parse(orderTextParts.length > 1 ? orderTextParts[1] : "");

            Runnable cmd = commands.get(action);
            if (cmd != null) {
                cmd.run();
            } else {
                System.out.println("존재하지 않는 명령어입니다.");
            }
        }
    }
}
