package org.back;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Long, WiseSaying> database = new HashMap<>();
    private static Long id = 1L;



    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        String command = "";
        Scanner sc = new Scanner(System.in);

        while(!command.equals("종료")){
            System.out.print("명령) ");
            command = sc.nextLine().trim();

            if (command.equals("등록")) {
                register_saying(sc);
            }else if(command.equals("목록")){
                saying_list();
            }else if(command.startsWith("삭제")){
                delete_saying(command);
            } else if (command.startsWith("수정")) {
                modify_saying(command, sc);
            }
        }


        System.out.println("명령) 종료\n");
    }

    private static void modify_saying(String command, Scanner sc) {
        String[] split = command.split("=");
        Long id = Long.parseLong(split[1]);

        if(database.containsKey(id)) {
            WiseSaying saying = database.get(id);
            System.out.println("명언(기존) : " + saying.getWiseSaying());
            System.out.print("명언 : ");
            String newSaying = sc.nextLine();
            System.out.println("작가(기존) : " + saying.getAuthor());
            System.out.print("작가 : ");
            String newAuthor = sc.nextLine();

            saying.modify(newSaying, newAuthor);
        }else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }

    }

    private static void delete_saying(String command) {
        String[] split = command.split("=");
        Long id = Long.parseLong(split[1]);
        if(database.containsKey(id)) {
            database.remove(id);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }else{
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    private static void saying_list() {
        System.out.print("""
번호 / 작가 / 명언
----------------------
                """);
        Long copied_id = id-1;
        while(copied_id>0){
            if(database.containsKey(copied_id)){
                WiseSaying saying = database.get(copied_id);
                System.out.println(copied_id + " / " + saying.getAuthor() + " / " + saying.getWiseSaying());
            }
            copied_id--;
        }
    }

    private static void register_saying(Scanner sc) {
        String wiseSaying = "";
        String author = "";

        System.out.print("명언 : ");
        wiseSaying = sc.nextLine().trim();

        System.out.print("작가 : ");
        author = sc.nextLine().trim();

        WiseSaying saying = new WiseSaying(wiseSaying, author);
        database.put(id, saying);

        System.out.println(id +"번 명언이 등록되었습니다.");
        id++;
    }
}

class WiseSaying{
    private String wiseSaying;
    private String author;

    public WiseSaying(String wiseSaying, String author) {
        this.wiseSaying = wiseSaying;
        this.author = author;
    }

    public String getWiseSaying() {
        return wiseSaying;
    }

    public String getAuthor() {
        return author;
    }

    public void modify(String newSaying, String newAuthor){
        this.wiseSaying = newSaying;
        this.author = newAuthor;
    }
}
