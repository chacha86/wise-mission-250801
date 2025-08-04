package com.wiseSaying;

import java.util.Scanner;

public class Main {

  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    String order; // 명령
    int i = 0;
    int id = 0; // 삭제 번호 확인
    WiseSaying[] wiseSaying = new WiseSaying[100];

    System.out.println("== 명언 앱 ==");
    while (true) {
      System.out.print("명령) ");
      order = sc.nextLine();
      if (order.equals("등록")) {
        wiseSaying[i] = new WiseSaying();
        register(wiseSaying[i], i);
        i++;

      } else if (order.equals("목록")) {
        inventory(wiseSaying, i);

      } else if (order.startsWith("삭제?id=")) {
        String[] idParts = order.split("=");
        id = Integer.parseInt(idParts[1]); // 문자 1을 숫자로 변환
        delete(wiseSaying, id);

      } else if (order.startsWith("수정?id=")) {
        String[] idParts = order.split("=");
        id = Integer.parseInt(idParts[1]); // 문자 1을 숫자로 변환
        change(wiseSaying, id);

      } else if (order.equals("종료")) {
        break;
      }
    }
  }

  public static void register(WiseSaying wiseSaying, int i) {//등록 메서드
    System.out.print("명언 : ");
    wiseSaying.Saying = sc.nextLine();
    System.out.print("작가 : ");
    wiseSaying.Author = sc.nextLine();
    wiseSaying.Num = i + 1;
    System.out.println((wiseSaying.Num) + "번 명언이 등록되었습니다.");
  }

  public static void inventory(WiseSaying[] wiseSayings, int i) { //목록 메서드
    System.out.println("번호 / 작가 / 명언");
    System.out.print("----------------------\n");
    while (i > 0) {
      if (wiseSayings[i - 1] != null) {
        System.out.println(wiseSayings[i - 1].Num + " / " + wiseSayings[i - 1].Saying + " /  " + wiseSayings[i - 1].Author);
      }
      i--;
    }
  }

  public static void delete(WiseSaying[] wiseSayings, int id) { //삭제 메서드
    if (wiseSayings[id - 1] == null) {
      System.out.println(id + "번 명언은 존재하지 않습니다.");
    } else {
      System.out.println(id + "번 명언이 삭제되었습니다.");
      wiseSayings[id - 1] = null;
    }
  }

  public static void change(WiseSaying[] wiseSayings, int id) { //수정 메서드
    if (wiseSayings[id - 1] != null) {
      System.out.print("명언(기존) : ");
      System.out.println(wiseSayings[id - 1].Saying);
      System.out.print("명언 : ");
      wiseSayings[id - 1].Saying = sc.nextLine();

      System.out.print("작가(기존) : ");
      System.out.println(wiseSayings[id - 1].Author);
      System.out.print("작가 : ");
      wiseSayings[id - 1].Author = sc.nextLine();
    } else {
      System.out.println(id + "번 명언은 존재하지 않습니다.");
    }
  }
}


