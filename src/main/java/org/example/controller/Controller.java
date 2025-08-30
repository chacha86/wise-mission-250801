package org.example.controller;

import org.example.entity.WiseSaying;
import org.example.service.Service;
import org.global.AppContext;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private Scanner scanner = AppContext.scanner;
    private Service service = AppContext.service;

    public void write() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        int id = service.write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> reversedWiseSayings = service.list();

        for(WiseSaying w: reversedWiseSayings) {
            System.out.println("%d / %s / %s".formatted(w.getId(), w.getContent(), w.getAuthor()));
        }

    }


    public void delete(int id) {
        WiseSaying wiseSaying = service.findByIdOrNull(id);

        if(wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        service.delete(id);
        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }


    public void edit(int id) {
        WiseSaying wiseSaying = service.findByIdOrNull(id);

        if(wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("명언(기존) : %s".formatted(wiseSaying.getContent()));
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.println("작가(기존) : %s".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String author = scanner.nextLine();


        service.edit(wiseSaying, content, author);
    }

}
