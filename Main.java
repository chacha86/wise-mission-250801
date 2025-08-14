package com.back;

import java.awt.event.WindowAdapter;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        WiseSaying[] wiseSayings = new WiseSaying[100];
        WiseSaying wiseSaying = null;

        int lastNum = 0; // 명언의 번호
        int no = 0; // 명언 배열의 번호

        while (true) {
            System.out.print("명령) ");
            String order = scanner.nextLine();

            if (order.equals("등록")) {
                System.out.print("명언 : ");
                String saying = scanner.nextLine();
                System.out.print("작자 : ");
                String author = scanner.nextLine();

                lastNum++;

                wiseSaying = new WiseSaying();
                wiseSaying.id = lastNum;
                wiseSaying.saying = saying;
                wiseSaying.author = author;

                wiseSayings[no++] = wiseSaying;


                System.out.println(lastNum + "번 명언이 등록되었습니다.");

            } else if(order.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i= no-1; i >= 0; i--){
                    System.out.println("%d / %s / %s".formatted(wiseSayings[i].id, wiseSayings[i].saying, wiseSayings[i].author));

                }
            }else if(order.startsWith("삭제?")){
                // 삭제할 번호 확인
                String[] command = order.split("=");

                if(command.length < 2) {
                    System.out.println("번호를 입력해주세요.");
                    return;
                }

                // 삭제할 번호
                String idstr = command[1];
                int id = Integer.parseInt(idstr);
                int targetId = -1;

                // 삭제할 번호 확인
                for(int i=0; i < no; i++) {
                    if (wiseSayings[i].id == id) {
                        targetId = i;
                        break;
                    }
                }

                if(targetId == -1){
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
                    return;
                }

                // 번호 삭제
                for(int i=targetId; i < wiseSayings.length - 1; i++) {
                    wiseSayings[i - 1] = wiseSayings[i];
                }

                no--;

                System.out.println("1번 명언이 삭제되었습니다.");

            } else if(order.startsWith("수정?")){
                // 수정할 번호 확인
                String[] command = order.split("=");

                if(command.length < 2) {
                    System.out.println("번호를 입력해주세요.");
                    return;
                }

                // 수정할 번호
                String idstr = command[1];
                int id = Integer.parseInt(idstr);
                int targetId = -1;

                // 수정할 번호 확인
                for(int i=0; i < no; i++) {
                    if (wiseSayings[i].id == id) {
                        targetId = i;
                        break;
                    }
                }

                if(targetId == -1){
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
                    return;
                }
                
                // 수정
                String originSaying = "";
                String originAuthor = "";

                originSaying = wiseSayings[targetId].saying;
                originAuthor = wiseSayings[targetId].author;
                System.out.println("명언(기존) : %s".formatted(originSaying));
                System.out.print("명언 : ");
                wiseSayings[targetId].saying = scanner.nextLine();

                System.out.println("작가(기존) : %s".formatted(originAuthor));
                System.out.print("작가 : ");
                wiseSayings[targetId].author = scanner.nextLine();
                
                
            }else if (order.equals("종료")) {
                break;
            }
        }
    }
}