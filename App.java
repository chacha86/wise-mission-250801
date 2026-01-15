package com.practice;

import java.io.*;
import java.util.*;

public class App {

  private final BufferedReader br;
  private final List<WiseSaying> quotes;
  private int nextId;

  public App() {
    this.br = new BufferedReader(new InputStreamReader(System.in));
    this.quotes = new ArrayList<>();
    this.nextId = 1;
  }

  public void run() throws IOException {
    System.out.println("== 명언 앱 ==");
    while (true) {
      System.out.print("명령) ");
      String command = readLineTrim();

      if (command.equals("종료")) {
        break;
      } else if (command.equals("등록")) {
        handleRegister();
      } else if (command.equals("목록")) {
        handleList();
      } else if (command.startsWith("삭제?id=")) {
        handleDelete(command);
      } else if (command.startsWith("수정?id=")) {
        handleEdit(command);
      } else {
        System.out.println("지원하지 않는 명령입니다.");
      }
    }
  }

  /* ========== Command Handlers ========== */

  private void handleRegister() throws IOException {
    String content = prompt("명언 : ");
    String author  = prompt("작가 : ");

    WiseSaying quote = new WiseSaying(nextId++, author, content);
    quotes.add(quote);
    System.out.println(quote.getId() + "번 명언이 등록되었습니다.");
  }

  private void handleList() {
    System.out.println("번호 / 작가 / 명언");
    System.out.println("---------------------------");

    ListIterator<WiseSaying> it = quotes.listIterator(quotes.size());
    while (it.hasPrevious()) {
      WiseSaying q = it.previous();
      System.out.println(q.getId() + " / " + q.getAuthor() + " / " + q.getContent());
    }
  }

  private void handleDelete(String command) {
    int id = parseId(command);
    if (id < 0) {
      System.out.println("id 파라미터가 올바르지 않습니다. 예) 삭제?id=1");
      return;
    }

    WiseSaying target = findById(id);
    if (target == null) {
      System.out.println(id + "번 명언은 존재하지 않습니다.");
    } else {
      quotes.remove(target);
      System.out.println(id + "번 명언이 삭제되었습니다.");
    }
  }

  private void handleEdit(String command) throws IOException {
    int id = parseId(command);
    if (id < 0) {
      System.out.println("id 파라미터가 올바르지 않습니다. 예) 수정?id=2");
      return;
    }

    WiseSaying target = findById(id);
    if (target == null) {
      System.out.println(id + "번 명언은 존재하지 않습니다.");
      return;
    }

    System.out.println("명언(기존) : " + target.getContent());
    String newContent = prompt("명언 : ");

    System.out.println("작가(기존) : " + target.getAuthor());
    String newAuthor = prompt("작가 : ");

    target.setContent(newContent);
    target.setAuthor(newAuthor);
  }

  /* ========== Helpers ========== */

  private int parseId(String command) {
    try {
      return Integer.parseInt(command.split("id=")[1].trim());
    } catch (Exception e) {
      return -1;
    }
  }

  private WiseSaying findById(int id) {
    for (WiseSaying q : quotes) {
      if (q.getId() == id) return q;
    }
    return null;
  }

  private String readLineTrim() throws IOException {
    return br.readLine().trim();
  }

  private String prompt(String label) throws IOException {
    System.out.print(label);
    return br.readLine();
  }
}

