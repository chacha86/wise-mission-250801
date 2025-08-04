package com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");
        Scanner scanner = new Scanner(System.in);
        String whatToDo = scanner.nextLine();
        int wiseNumber = 0;
        ArrayList<Wise> wiseList = new ArrayList<>(); // ArrayList 는 class 타입으로 선언한다.
        while (true) {
            Wise wise = new Wise();
            if (whatToDo.equals("종료")) {
                break;
            } else if (whatToDo.equals("등록")) {
                System.out.print("명언 : ");
                String title = scanner.nextLine();
                System.out.print("작가 : ");
                String name = scanner.nextLine();
                wiseNumber++;
                wise.enter(wiseNumber, name, title);
                System.out.println(wiseNumber + "번 명언이 등록되었습니다.");
                wiseList.add(wise);
                System.out.print("명령) ");
                whatToDo = scanner.nextLine();
            } else if (whatToDo.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = wiseList.size() - 1; i >= 0; i--) {
                    if (wiseList.get(i).wise == null) {
                        // nothing
                    } else {
                        System.out.println(wiseList.get(i).number + " / " + wiseList.get(i).writer + " / " + wiseList.get(i).wise);
                    }
                }
                System.out.print("명령) ");
                whatToDo = scanner.nextLine();
            } else if (whatToDo.equals("삭제")) {
                System.out.print("id=");
                String numStr = scanner.nextLine();
                int num = Integer.parseInt(numStr);
                if (num < 1 || num > wiseList.size() || wiseList.get(num-1).wise == null) { // null 도 size 값에 포함된다
                    System.out.println(num + "번 명언은 존재하지 않습니다.");
                } else {
                    // 값 삭제 -> Null로 만들기 -> ArrayList 는 요소를 삭제하면 다른 요소들이 빈 공간을 매꾼다.
                    // 그래서 클래스를 사용한다.
                    System.out.println(num + "번 명언이 삭제되었습니다.");
                    wiseList.get(num-1).wise = null;
                    wiseList.get(num-1).writer = null;
                }
                System.out.print("명령) ");
                whatToDo = scanner.nextLine();
            } else if (whatToDo.equals("수정")) {
                System.out.print("id=");
                String numStr = scanner.nextLine();
                int num = Integer.parseInt(numStr);
                if (num < 1 || num > wiseList.size() || wiseList.get(num-1).wise == null) { // null 도 size 값에 포함된다
                    System.out.println(num + "번 명언은 존재하지 않습니다.");
                } else {
                    System.out.println("명언(기존) : " + wiseList.get(num-1).wise);
                    System.out.print("명언 : ");
                    String newWise = scanner.nextLine();
                    System.out.println("작가(기존) : " + wiseList.get(num-1).writer);
                    System.out.print("작가 : ");
                    String newWriter = scanner.nextLine();
                    wiseList.get(num-1).wise = newWise;
                    wiseList.get(num-1).writer = newWriter;
                }
                System.out.print("명령) ");
                whatToDo = scanner.nextLine();
            } else {
                System.out.println("잘못된 명령입니다. 다시 입력해주세요");
                System.out.print("명령) ");
                whatToDo = scanner.nextLine();
            }
        }
    }
}