package com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command; //명령
        int num = 0; //등록 수
        ArrayList<Note> note = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            command = sc.nextLine();

            if (command.equals("종료")) {
                break;
            }

            //등록
            if (command.equals("등록")) {
                num++;

                System.out.print("명언 : ");
                String saying = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                note.add(new Note(num, author, saying));
                System.out.println(num + "번 명언이 등록되었습니다.");
            }

            //목록
            if(command.equals("목록")) {
                System.out.println("번호  / 작가  / 명언");
                System.out.println("-----------------------------");

                for(int i = note.size() -1; i >= 0; i--) {
                    Note n = note.get(i);
                    System.out.println(" " + n.id + " /  " + n.author + "/ " + n.saying);
                }
            }

            //삭제
            if(command.startsWith("삭제?id=")){
                int deleteId = Integer.parseInt(command.substring(6));
                boolean flag = false;

                for(int i = 0; i < note.size(); i++) {
                    if(note.get(i).id == deleteId) {
                        note.remove(i);
                        System.out.println(deleteId + "번 명언이 삭제되었습니다.");
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
                }
            }

            //수정
            if(command.startsWith("수정?id=")){
                int updateId = Integer.parseInt(command.substring(6));
                boolean flag = false;

                for(int i = 0; i < note.size(); i++) {
                    if(note.get(i).id == updateId) {
                        Note n = note.get(i);

                        System.out.println( "명언(기존) : " + n.saying);
                        System.out.print("명언 : ");
                        String newSaying = sc.nextLine();


                        System.out.println( "작가(기존) : " + n.author);
                        System.out.print("작가 : ");
                        String newAuthor = sc.nextLine();

                        n.saying = newSaying;
                        n.author = newAuthor;

                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    System.out.println(updateId + "번 명언은 존재하지 않습니다.");
                }
            }
        }
    }
}
