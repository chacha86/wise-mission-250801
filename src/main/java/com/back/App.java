package com.back;

import java.util.Scanner;

class App{
    Scanner sc = new Scanner(System.in);
    WiseQuote[] wiseQuotes = new WiseQuote[100];
    int lastIndex = 0;

    void run(){
        System.out.println("== 명언 앱 ==");

        while (true){
            System.out.print("명언) ");
            String command = sc.nextLine();

            if(command.equals("등록")){
                register();

            } else if(command.equals("목록")){
                listUp();

            } else if(command.startsWith("삭제")){
                delete(command);

            } else if(command.startsWith("수정")) {
                correct(command);

            } else if (command.equals("종료")) {
                System.out.println("종료하겠습니다");
                break;
            }
            }

        }
        void register(){
            System.out.print("명언 : ");
            String quote = sc.nextLine();
            System.out.print("작가 : ");
            String author = sc.nextLine();

            WiseQuote newQuote = write(quote, author);

            System.out.println("%d번 명언이 등록되었습니다.".formatted(lastIndex));
        }
    WiseQuote write(String quote, String author){
            WiseQuote newQuote = new WiseQuote(lastIndex + 1, quote, author);

            wiseQuotes[lastIndex] = newQuote;
            lastIndex++;
            return newQuote;

        }

        void listUp(){

            System.out.println("번호 / 작가 / 명언");
            System.out.println("----------------------");

            WiseQuote[] desList = declist();
            for(WiseQuote quote : desList){
                System.out.println("%d / %s / %s".formatted(quote.getId(), quote.getQuote(), quote.getAuthor()));
            }

        }

        WiseQuote[] declist(){
        WiseQuote[] quoteList = new WiseQuote[lastIndex];
        int quoteListIndex = 0;

            for(int i=lastIndex-1; i>=0; i--){
                if (wiseQuotes[i] == null){
                    continue;
                }
                if (quoteListIndex < quoteList.length) {
                    quoteList[quoteListIndex++] = wiseQuotes[i];
                }
            }
return quoteList;

}
        void delete(String command){
        String [] bits = command.split("=",2);
           int delIndex =-1;
        if(bits.length<2){
            System.out.println("번호를 입력해주세요.");
            return;
        }
            int targetId = Integer.parseInt(bits[1]);
            for (int i = 0; i < lastIndex; i++) {
                if (wiseQuotes[i] != null && wiseQuotes[i].getId() == targetId) {
                    delIndex = i;
                    break;
                }
            }
            if (delIndex == -1) {
                System.out.println("%d번 명언이 존재하지 않습니다.".formatted(targetId));
                return;
            }
            for (int i = delIndex; i < lastIndex - 1; i++) {
                wiseQuotes[i] = wiseQuotes[i + 1];
            }
            wiseQuotes[lastIndex - 1] = null;
            lastIndex--;
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(targetId));

//            int delIndex = sc.nextInt();
//            sc.nextLine();
//            if(delIndex <= lastIndex && delIndex >0){
//            wiseQuotes[delIndex-1] = null;
//            System.out.println("%d번 명언이 삭제되었습니다.".formatted(delIndex));
//        } else {
//            System.out.println("%d번 명언이 존재하지 않습니다.".formatted(delIndex));
//        }

        }


        void correct(String command){
//        WiseQuote corQuote = new WiseQuote();
            String [] bits = command.split("=",2);

            if(bits.length<2){
                System.out.println("번호를 입력해주세요.");
                return;
            }
            int targetId = Integer.parseInt(bits[1]);
            int corIndex =-1;
            for (int i = 0; i < lastIndex; i++) {
                if (wiseQuotes[i] != null && wiseQuotes[i].getId() == targetId) {
                    corIndex = i;
                    break;
                }
            }
            if (corIndex == -1) {
                System.out.println("%d번 명언이 존재하지 않습니다.".formatted(targetId));
                return;
            }
                System.out.println("명언(기존) : " + wiseQuotes[corIndex].getQuote());
                System.out.print("명언 : ");
                String fixQuote = sc.nextLine();
                System.out.println("작가(기존) : " + wiseQuotes[corIndex].getAuthor());
                System.out.print("작가 : ");
                String fixAuthor = sc.nextLine();
                wiseQuotes[corIndex].setQuote(fixQuote);
                wiseQuotes[corIndex].setAuthor(fixAuthor);
                System.out.println("%d번 명언이 수정되었습니다.".formatted(targetId));


//            System.out.print("수정?id=");
//            int corIndex = sc.nextInt();
//            sc.nextLine();
//            if(corIndex <= lastIndex && corIndex >0){
//                System.out.println("명언(기존) : " + wiseQuotes[corIndex-1].getQuote());
//                System.out.print("명언 : ");
//                String fixQuote = sc.nextLine();
//                System.out.println("작가(기존) : " + wiseQuotes[corIndex-1].getAuthor());
//                System.out.print("작가 : ");
//                String fixAuthor = sc.nextLine();
//                wiseQuotes[corIndex-1].setQuote(fixQuote);
//                wiseQuotes[corIndex-1].setAuthor(fixAuthor);
//                System.out.println("%d번 명언이 수정되었습니다.".formatted(corIndex));
//            } else{
//                System.out.println("%d번 명언이 존재하지 않습니다.".formatted(corIndex));
//            }

        }





    }



