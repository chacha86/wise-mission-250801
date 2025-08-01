package com.back.WiseSaying.controller;

import com.back.WiseSaying.model.WiseSaying;
import com.back.WiseSaying.service.WiseSayingService;

import java.util.Map;
import java.util.Scanner;

public class WiseSayingController {
    WiseSayingService service = new WiseSayingService();

    public void exitCommand()
    {
        service.exit();
    }

    public void registerCommand(Scanner sc)
    {
        WiseSaying newSaying = new WiseSaying();
        System.out.print("명언 : ");
        newSaying.content = sc.nextLine();
        System.out.print("작가 : ");
        newSaying.author = sc.nextLine();
        service.register(newSaying);
        System.out.println(service.getCurrentIndex() + "번 명언이 등록되었습니다.");
    }

    public void deleteCommand(Map<String, String> params)
    {
        int id = Integer.parseInt(params.get("id"));
        if(service.delete(id))
        {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
        else
        {
            System.out.println(id + "번 명언이 존재하지 않습니다.");
        }
    }

    public void showListCommand()
    {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------");
        for (int i = service.getCurrentIndex(); i >= 1; i--) {
            if (!service.findById((i)).isDelete) {
                System.out.println(i + " / " + service.findById(i).author + " / " + service.findById(i).content);
            }
        }
    }

    public void changeCommand(Map<String, String> params, Scanner sc)
    {
        int id = Integer.parseInt(params.get("id"));
        WiseSaying say = service.findById(id);
        if (service.findById(id) != null) {
            String content, author;
            System.out.println("명언(기존) : " + say.content);
            System.out.print("명언 : ");
            content = sc.nextLine();
            System.out.println("작가(기존) : " + say.author);
            System.out.print("작가 : ");
            author = sc.nextLine();

            service.change(id, author, content);

        } else {
            System.out.println(id + "번 명언이 존재하지 않습니다.");
        }
    }

}
