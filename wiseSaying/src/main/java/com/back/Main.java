package com.back;

import com.back.Wise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Wise> list = new ArrayList<>();
        int number = 1;

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String quote = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                list.add(new Wise(number, quote, author));
                System.out.println(number++ + "번 명언이 등록되었습니다.");
            }
            else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.println(list.get(i).number + " / " + list.get(i).author + " / " + list.get(i).quote);
                }
            }
            else if (cmd.startsWith("삭제?id=")) {
                String ids = cmd.substring("삭제?id=".length());
                int id = Integer.parseInt(ids);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).number == id){
                        list.remove(i);
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                        break ;
                    }
                    else {
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                        break ;
                    }
                }
            }
            else if (cmd.startsWith("수정?id=")) {
                String ids = cmd.substring("수정?id=".length());
                int id = Integer.parseInt(ids);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).number == id){
                        System.out.println("명언(기존) : " + list.get(i).quote);
                        System.out.print("명언 : ");
                        list.get(i).quote = sc.nextLine();
                        System.out.println("작가(기존) : " + list.get(i).author);
                        System.out.print("작가 : ");
                        list.get(i).author = sc.nextLine();
                        break ;
                    }
                    else {
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                        break ;
                    }
                }
            }
            else if (cmd.equals("종료")) {
                sc.close();
                break ;
            }
        }
    }
}
