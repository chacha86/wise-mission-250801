package org.example;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        int word_count = 0;
        String[][] wordList = new String[100][3];
        System.out.println("== 명언 앱 ==");


        while(true) {
            System.out.print("명령) ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.flush();
            String input = br.readLine();

            if(input.equals("종료")) {
                return;
            } else if (input.equals("등록")) {
                word_count++;
                System.out.print("명언 : ");
                String words = br.readLine();
                wordList[word_count][2] = words;
                System.out.print("작가 : ");
                String author = br.readLine();
                wordList[word_count][1] = author;
                System.out.println(word_count + "번 명언이 등록되었습니다.");
                wordList[word_count][0] = Integer.toString(word_count);
            } else if (input.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                int list_n = word_count;

                while(list_n > 0) {
                    if(wordList[list_n][0].equals("0")) {
                        list_n--;
                        continue;
                    }
                    System.out.println(wordList[list_n][0] + " / " + wordList[list_n][1] + " / " + wordList[list_n][2]);
                    list_n--;
                }
            } else {
                String[] operator = input.split("\\?", 2);
                String[] id_n = operator[1].split("="); // 실제 id_n은 id_n[1] String 형
                int id_erase = Integer.parseInt(id_n[1]);

                if(wordList[id_erase][0] == null || wordList[id_erase][0].equals("0")) {
                    System.out.println(id_n[1] + "번 명언은 존재하지 않습니다.");
                    continue;
                }

                if(operator[0].equals("삭제")) {
                    wordList[id_erase][0]= "0";
                    System.out.println(id_n[1] + "번 명언이 삭제되었습니다.");
                } else if (operator[0].equals(("수정"))) {
                    int id_n_2 = Integer.parseInt(id_n[1]);
                    System.out.println("명언(기존) : " + wordList[id_n_2][2]);
                    System.out.print("명언 : ");
                    String new_words = br.readLine();
                    wordList[id_n_2][2] = new_words;
                    System.out.println("작가(기존) : " + wordList[id_n_2][1]);
                    System.out.print("작가 : ");
                    String new_author = br.readLine();
                    wordList[id_n_2][2] = new_author;
                }else {
                    System.out.println("명령어 잘못 입력");
                }

            }

        }

    }
}