package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int idx = 0;

    public static void main(String[] args) {
        List<WiseSaying> wsList = new ArrayList<>();
        Scanner kb = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        while (true){

            System.out.print("명령) ");
            String command = kb.nextLine();

            if(command.equals("종료")){
                break;
            } else if(command.equals("등록")){
                addWiseSaying(wsList);
                wsList.sort(null);
            } else if(command.equals("목록")){
                printWiseSayings(wsList);
            } else if(command.contains("삭제")){
                removeWiseSayings(wsList, Integer.parseInt(command.split("=")[1]));
            } else if(command.contains("수정")){
                modifyWiseSayings(wsList, Integer.parseInt(command.split("=")[1]));
            }
        }
    }

    static void modifyWiseSayings(List<WiseSaying> wsList, int id) {
        WiseSaying ws = findWiseSaying(wsList, id);

        if(ws != null) {
            Scanner kb = new Scanner(System.in);
            System.out.println("명언(기존) : " + ws.getContent());
            System.out.print("명언 : ");
            ws.setContent(kb.nextLine());
            System.out.println("작가(기존) : " + ws.getAuthor());
            System.out.print("작가 : ");
            ws.setAuthor(kb.nextLine());
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }

    }

    static void removeWiseSayings(List<WiseSaying> wsList, int id) {
        WiseSaying ws = findWiseSaying(wsList, id);
        if(ws != null){
            wsList.remove(ws);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    static WiseSaying findWiseSaying(List<WiseSaying> wsList, int id) {
        for (WiseSaying wiseSaying : wsList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    static void addWiseSaying(List<WiseSaying> wsList){
        Scanner kb = new Scanner(System.in);

        System.out.print("명언 : ");
        String ws = kb.nextLine();
        System.out.print("작가 : ");
        String author = kb.nextLine();

        wsList.add(new WiseSaying(++idx, ws, author));
        System.out.println(idx + "번 명언이 등록되었습니다.");
    }

    static void printWiseSayings(List<WiseSaying> wsList){
        System.out.println("번호 / 작가 / 명언 " +
                "\n----------------------");
        for(WiseSaying ws : wsList){
            System.out.println(ws);
        }
    }

    static class WiseSaying implements Comparable<WiseSaying>{

        private int id;
        private String content;
        private String author;

        public WiseSaying(int id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }

        public int getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public int compareTo(WiseSaying o) {
            return this.id > o.getId() ? -1 : this.id < o.getId() ? 1 : 0;
        }

        @Override
        public String toString() {
            return  id
                    + " / " + author
                    + " / " + content;
        }
    }
}