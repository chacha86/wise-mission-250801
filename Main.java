package com.back;
import java.util.Scanner;

public class Main {
    private static String command = "";
    private static String wiseSaying = "";
    private static String author = "";
    private static WiseSaying[] wiseSayingArray = new WiseSaying[5];
    private static int wiseSayingCount = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== 명언 앱 ===");
        wiseSayingAppRunner();
    }

    private static void wiseSayingAppRunner(){
        while(true){
            commandReader();
            String selectWord = command.substring(0,2);

            if(selectWord.equals("종료")) break;

            if(selectWord.equals("등록")) {
                wiseSayingReader();
                wiseSayingSaver();
            }
            if(selectWord.equals("목록")){
                setWiseSayingPrinter();
            }
            if(selectWord.equals("삭제")){
                wiseSayingDeleter();
            }
            if(selectWord.equals("수정")){
                setWiseSayingCorrector();
            }
        }
    }

    private static void commandReader() {
        System.out.print("명령 : ");
        command = sc.nextLine();
    }

    private static void wiseSayingSaver(){
        if(wiseSaying.length()>=wiseSayingCount){
            wiseSayingPutInArray();
        } else{
            arrayMakeBigger();
            wiseSayingPutInArray();
        }
        System.out.println(wiseSayingCount + "번 명언이 등록되었습니다.");
    }

    private static void wiseSayingReader() {
        System.out.print("명언 : ");
        wiseSaying = sc.nextLine();
        System.out.print("작가 : ");
        author = sc.nextLine();
    }

    private static void wiseSayingPutInArray(){
        wiseSayingArray[wiseSayingCount] = new WiseSaying(wiseSayingCount+1,author, wiseSaying);
        wiseSayingCount++;
    }

    private static void arrayMakeBigger(){
        WiseSaying[] biggerWSArray = new WiseSaying[wiseSayingCount*2];
        System.arraycopy(wiseSayingArray,0 ,biggerWSArray, 0,wiseSayingArray.length-1);
        wiseSayingArray = biggerWSArray;
    }

    private static void setWiseSayingPrinter(){
        System.out.println("번호  /   작가  /   명언");
        System.out.println("----------------------");
        for(WiseSaying ws: wiseSayingArray){
            if(ws == null)continue;
            if(ws.isDeleted()) System.out.println(ws.getNum() + "번 명언은 존재하지 않습니다.");
            else System.out.println(ws.contentPrint());
        }
    }
    private static void wiseSayingDeleter(){
        String[] splitedCommand = command.split("=");
        int deleteTarget = Integer.parseInt(splitedCommand[1]);
        deleteTarget--;

        if(isWiseSayingExist(deleteTarget)){
            wiseSayingArray[deleteTarget].setDeleted();
            System.out.println(deleteTarget+1 +"번 명언이 삭제되었습니다.");
        }
    }

    private static void setWiseSayingCorrector(){
        String[] splitedCommand = command.split("=");
        int correctionTarget = Integer.parseInt(splitedCommand[1]);
        correctionTarget--;

        if(isWiseSayingExist(correctionTarget)){
            System.out.println("명언(기존) : " + wiseSayingArray[correctionTarget].getWiseSaying());
            System.out.print("명언 : ");
            String correctedWiseSaying =  sc.nextLine();
            System.out.println("작가(기존) : " + wiseSayingArray[correctionTarget].getAuthor());
            System.out.print("작가 : ");
            String correctedAuthor = sc.nextLine();
            wiseSayingArray[correctionTarget].setWiseSaying(correctedWiseSaying);
            wiseSayingArray[correctionTarget].setAuthor(correctedAuthor);
        }

    }

    private static boolean isWiseSayingExist(int number){
        if(wiseSayingArray[number] == null || wiseSayingArray[number].isDeleted()){
            System.out.println(number+1 +"번 명언은 존재하지 않습니다.");
            return false;
        } else {
            return true;
        }
    }




}
