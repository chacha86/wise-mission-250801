package org.example;

import java.util.*;
import java.io.*;
import java.util.regex.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {
        ArrayList<Idiom> listIdioms = new ArrayList<>();

        while(true){
            //명령 받기
            System.out.print("명령) ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String cmd = br.readLine().trim();
            if(cmd.equals("종료")){
                //1단계: 종료.
                br.close();
                break;
            }
            else if(cmd.equals("등록")){
                //2단계: 등록.
                //3단계: 등록시 생성된 명언번호 노출.
                //4단계: 등록 시 명언번호 증가.
                int number = listIdioms.size() +  1;
                System.out.print("명언 : ");
                String idiom = br.readLine();
                System.out.print("작가 : ");
                String author = br.readLine();

                listIdioms.add(new Idiom(number = number,
                        idiom = idiom,
                        author = author));

                System.out.printf("%d번 명언이 등록되었습니다.", number);
                System.out.println();
            }
            else if(cmd.equals("목록")){
                //5단계: 목록.
                System.out.println("---------------------");
                for(Idiom item : listIdioms) {
                    System.out.printf("%d / %s / %s", item.getNumber(), item.getAuthor(), item.getIdiom()).println();
                }
            }
            else if(cmd.contains("삭제")){
                //6단계: 명언삭제.
                boolean erased = false;
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(cmd);
                int numTar = 0;
                if(matcher.find()){
                    numTar = Integer.parseInt(matcher.group());
                }

                for(int i = 0; i < listIdioms.size(); i ++){
                    if(listIdioms.get(i).getNumber() == numTar){
                        listIdioms.remove(i);
                        erased = true;
                        break;
                    }
                }
                //7단계: 존재하지 않는 명언삭제에 대한 예외처리.
                if(erased == false) System.out.printf("%d번 명언은 존재하지 않습니다.\n", numTar);
                else System.out.printf("%d번 명언이 삭제되었습니다.\n", numTar);
            }
            else if(cmd.contains("수정")){
                //8단계: 명언수정.
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(cmd);
                int numTar = 0;
                if(matcher.find()){
                    numTar = Integer.parseInt(matcher.group());
                }

                for(int i = 0; i < listIdioms.size(); i ++){
                    if(listIdioms.get(i).getNumber() == numTar){
                        System.out.printf("명언(기존) : %s\n", listIdioms.get(i).getIdiom());
                        System.out.print("명언 : ");
                        String idiom = br.readLine();
                        listIdioms.get(i).setIdiom(idiom);
                        System.out.println();
                        System.out.printf("작가(기존) : %s\n", listIdioms.get(i).getAuthor());
                        System.out.print("작가 : ");
                        String author = br.readLine();
                        listIdioms.get(i).setAuthor(author);
                        System.out.println();
                        break;
                    }
                }
            }

            else{
                System.out.println("알 수 없는 명령입니다.");
            }
        }

    }

}