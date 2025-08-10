package com;

import java.util.Scanner;


public class App {
    // 사용자 입력을 받는 스캐너 객체 (정적 필드: 클래스에 한 번만 생성되며 모든 인스턴스가 공유)
    private Scanner sc = new Scanner(System.in);

    public void run() {
        System.out.println("==명언 앱=="); // 앱 시작 메시지 출력
        QuoteController quoteController = new QuoteController();

        // 애플리케이션의 메인 루프: 사용자가 '종료' 명령을 입력할 때까지 반복
        while (true) {
            System.out.print("명령) ");
            String order = sc.nextLine(); // 사용자 명령 입력
            Rq rq = new Rq(order);
            String actionName = rq.getActionName();

            // 각 명령에 따라 QuoteController의 해당 정적 메서드 호출
            if (actionName.equals("등록")) {
                quoteController.addQuote(); // QuoteController.addQuote() 호출
            } else if (actionName.equals("목록")) {
                quoteController.listQuotes(); // QuoteController.listQuotes() 호출
            } else if (actionName.startsWith("삭제")) {
                quoteController.deleteQuote(rq); // QuoteController.deleteQuote() 호출
            } else if (actionName.startsWith("수정")) {
                quoteController.modifyQuote(rq); // QuoteController.modifyQuote() 호출
            } else if (actionName.equals("종료")) { // '종료' 명령 처리: 루프를 종료하고 앱 종료 메시지 출력
                System.out.println("명언 앱을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 명령입니다."); // 알 수 없는 명령 처리
            }
        }
        sc.close(); // 앱 종료 시 스캐너 리소스 해제
    }
}