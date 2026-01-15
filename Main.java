package com.practice;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    App app = new App();
    app.run();


//    int nextId = 1;
//    List<WiseSaying> quotes = new ArrayList<>();
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    System.out.println("== 명언 앱 ==");
//
//    while (true) {
//      System.out.print("명령) ");
//      String command = br.readLine().trim();
//
//      if (command.equals("종료")) {
//        break;
//
//      } else if (command.equals("등록")) {
//        System.out.print("명언 : ");
//        String content = br.readLine();
//        System.out.print("작가 : ");
//        String author = br.readLine();
//
//        WiseSaying quote = new WiseSaying(nextId++, author, content);
//        quotes.add(quote);
//        System.out.println(quote.getId() + "번 명언이 등록되었습니다.");
//
//      } else if (command.equals("목록")) {
//        System.out.println("번호 / 작가 / 명언");
//        System.out.println("---------------------------");
//
//        ListIterator<WiseSaying> iterator = quotes.listIterator(quotes.size());
//        while (iterator.hasPrevious()) {
//          WiseSaying q = iterator.previous();
//          System.out.println(q.getId() + " / " + q.getAuthor() + " / " + q.getContent());
//        }
//
////        for (int i = quotes.size() - 1; i >= 0; i--) {
////          Quote q = quotes.get(i);
////          System.out.println(q.getId() + " / " + q.getAuthor() + " / " + q.getContent());
////        }
//
//
//      } else if (command.startsWith("삭제?id=")) {
//        int id = parseId(command);
//        WiseSaying toRemove = findById(quotes, id);
//
//        if (toRemove == null) {
//          System.out.println(id + "번 명언은 존재하지 않습니다.");
//        } else {
//          quotes.remove(toRemove);
//          System.out.println(id + "번 명언이 삭제되었습니다.");
//        }
//
//      } else if (command.startsWith("수정?id=")) {
//        int id = parseId(command);
//        WiseSaying toEdit = findById(quotes, id);
//
//        if (toEdit == null) {
//          System.out.println(id + "번 명언은 존재하지 않습니다.");
//        } else {
//          System.out.println("명언(기존) : " + toEdit.getContent());
//          System.out.print("명언 : ");
//          String newContent = br.readLine();
//
//          System.out.println("작가(기존) : " + toEdit.getAuthor());
//          System.out.print("작가 : ");
//          String newAuthor = br.readLine();
//
//          toEdit.setContent(newContent);
//          toEdit.setAuthor(newAuthor);
//        }
//
//      } else {
//        System.out.println("지원하지 않는 명령입니다.");
//      }
//    }
//  }
//
//  // 파라미터에서 id=숫자 추출
//  private static int parseId(String command) {
//    try {
//      return Integer.parseInt(command.split("id=")[1]);
//    } catch (Exception e) {
//      return -1;
//    }
//  }
//
//  // ID로 명언 찾기
//  private static WiseSaying findById(List<WiseSaying> list, int id) {
//    for (WiseSaying q : list) {
//      if (q.getId() == id) return q;
//    }
//    return null;

  }
}