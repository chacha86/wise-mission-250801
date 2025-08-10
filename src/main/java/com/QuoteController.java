package com;

import java.util.*;

public class QuoteController {
    // 모든 명언 객체를 저장하는 리스트 (애플리케이션 전역에서 공유되는 정적 필드)
    private static List<Quote> quoteList = new ArrayList<>();
    // 다음에 부여될 명언 ID (애플리케이션 전역에서 공유되는 정적 필드)
    private static int nextQuoteId = 1;
    // 사용자 입력을 받는 스캐너 객체 (애플리케이션 전역에서 공유되는 정적 필드)
    private final Scanner sc = new Scanner(System.in);


    public void addQuote() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        Quote newQuote = new Quote(nextQuoteId, saying, author);
        quoteList.add(newQuote);

        System.out.printf("%d번 명언이 등록되었습니다.%n", nextQuoteId);
        nextQuoteId++;
    }

    public void listQuotes() {
        if (quoteList.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            System.out.println("번호 / 작가 / 명언");
            System.out.println("----------------------");
            quoteList = quoteList.reversed();
            for (Quote quote : quoteList) {
                System.out.printf("%d / %s / %s%n", quote.getId(), quote.getAuthor(), quote.getSaying());
            }
        }
    }


    public void deleteQuote(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        if (id == -1) {
            System.out.println("잘못된 명령입니다.");
        }
        boolean deleteOrFalse = delete(id);

        if (!deleteOrFalse) {
            System.out.printf("%d번 명언은 존재하지 않습니다.%n", id);
        } else
            System.out.printf("%d번 명언이 삭제되었습니다.%n", id);
    }


    public void modifyQuote(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        if (id == -1) {
            System.out.println("잘못된 명령입니다.");
        }
        Quote modifiedQuote = findByIdOrNull(id);
        if (modifiedQuote == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.%n", id);
            return;
        }

        System.out.printf("명언(기존) : %s%n", modifiedQuote.getSaying());
        System.out.print("명언 : ");
        String newSaying = sc.nextLine();

        System.out.printf("작가(기존) : %s%n", modifiedQuote.getAuthor());
        System.out.print("작가 : ");
        String newAuthor = sc.nextLine();

        modify(modifiedQuote, newSaying, newAuthor);
    }

    private void modify(Quote quote, String newSaying, String newAuthor) {
        quote.setSaying(newSaying);
        quote.setAuthor(newAuthor);
        System.out.printf("%d번 명언이 수정되었습니다.%n", quote.getId());
    }

    private Quote findByIdOrNull(int id) {
        return quoteList.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private boolean delete(int id) {
        return quoteList.removeIf(q -> q.getId() == id);
    }
}