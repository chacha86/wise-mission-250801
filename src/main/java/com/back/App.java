package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    WiseSaying wiseSayings[] = new WiseSaying[100]; //WiseSaying 객체를 담을 배열 선언
    List<String> quotes = new ArrayList<>(); //배열의 길이를 동적으로 다룰 수 있다

    int count = 0; //명언의 번호
    int lastIndex = 0; //가장 마지막에 저장된 배열의 위치

    public void run() {

        boolean run = true;
        System.out.println("== 명언 앱 ==");
        //List<String> quotes = new ArrayList<>();

            while(run) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("등록")) {
                actionWrite();
            }
            else if(command.equals("목록")) {
                actionList();

            }
            else if(command.startsWith("수정")) {
                actionModify(command);

            }
            else if(command.startsWith("삭제")) { //삭제로 시작하는 명령어 확인
                actionDelete(command);
            }
            else if(command.equals("종료")) {
                run = false;
            }
            else {
                System.out.println("알 수 없는 명령입니다.");
            }
        }
    }

    public void actionDelete(String command) {
        String[] commandBits = command.split("="); //split시 배열로 받아짐
        if(commandBits.length < 2) { //명령어에 id가 없을 경우. 즉 "삭제?id="만 입력된 경우
            System.out.println("번호를 입력해주세요.");
            return; //함수 그냥 종료
        }

        String idStr = commandBits[1]; //명령어에서 id 부분만 추출
        int id = Integer.parseInt(idStr); //문자열을 정수로 변환



        boolean result = delete(id);
        if(result){
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id)); //삭제된 명언의 id 출력
        }else {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }
    }

    public int findIndexById(int id){ //id를 넣으면 그 id가 저장소 몇 번째에 저장되어있는지 리턴하는 함수
        for(int i = 0; i<lastIndex;i++){
            if(wiseSayings[i].id == id) { //삭제할 명언의 id가 1인 경우
                return i;
            }
        }
        return -1; //삭제할 명언이 없는 경우
    }
    public boolean delete(int id){
        int deleteTargetIndex = findIndexById(id); //삭제할 명언의 인덱스 찾기

        if(deleteTargetIndex == -1) { //삭제할 명언이 없는 경우
            return false; //함수 그냥 종료 (존재하지않는데 삭제 알고리즘을 실행할 필요 없음)
            // -> return 만나면 함수가 그 즉시 종료
        }

        for(int i = deleteTargetIndex; i < lastIndex; i++) {
            wiseSayings[i] = wiseSayings[i + 1]; //삭제할 명언 이후의 요소들을 앞으로 한 칸씩 이동
        }
        lastIndex--; //마지막 인덱스 감소 (마지막 인덱스 안 쓸 것이기 때문)
        return true; //삭제 성공
    }

    public void actionModify(String command) {
        String[] commandBits = command.split("=");
        if(commandBits.length<2){
            System.out.println("번호를 입력해주세요.");
            return; //함수 그냥 종료
        }


        String idStr = commandBits[1]; //명령어에서 id 부분만 추출
        int id = Integer.parseInt(idStr); //문자열을 정수로 변환

        int modifyTargetIndex = findIndexById(id); //수정할 명언의 인덱스 찾기

        if(modifyTargetIndex == -1){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }; //수정할 명언의 인덱스 초기화

        WiseSaying modifyTargetWiseSaying = wiseSayings[modifyTargetIndex]; //수정할 명언의 WiseSaying 객체 가져오기

        System.out.println("명언(기존): %s".formatted(modifyTargetWiseSaying.quote));
        System.out.print("명언: ");
        String newQuote = scanner.nextLine(); //새로운 명언 입력 받기
        System.out.println("작가(기존): %s".formatted(modifyTargetWiseSaying.author));
        System.out.print("작가: ");
        String newAuthor = scanner.nextLine(); //새로운 작가 입력 받기

        modify(modifyTargetWiseSaying, newQuote, newAuthor); //명언과 작가 수정 메서드 호출

    }

    public void modify(WiseSaying modifyTargetWiseSaying, String newQuote, String newAuthor) {
        modifyTargetWiseSaying.quote = newQuote; //명언 수정
        modifyTargetWiseSaying.author = newAuthor; //작가 수정
    }

    public void actionWrite() { //사용자와 실제 상호작용 부분
        System.out.print("명언: ");
        String quote = scanner.nextLine();
        System.out.print("작가: ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = write(quote, author); //write 메서드 호출하여 명언 등록

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.id));

    }

    public WiseSaying write(String quote, String author){ //데이터처리 담당, writeAction의 매개변수 전달
        count += 1;
        WiseSaying wiseSaying = new WiseSaying(); //새로운 WiseSaying 객체 생성
        wiseSaying.id = count;
        wiseSaying.quote = quote;
        wiseSaying.author = author;
        wiseSayings[lastIndex++] = wiseSaying; //배열에 WiseSaying 객체 저장

        return wiseSaying; //write에 저장된 값을 저장하여 actionWrite 메서드로 반환
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        WiseSaying[] wiseSayings = findListDesc(); //내림차순으로 정렬된 WiseSaying 배열을 가져옴

        for(WiseSaying wiseSaying : wiseSayings) { //향상된 for문: 오른쪽에서 다 꺼내와서 wiseSaying 변수에 저장
            System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.quote));
            //명언의 번호 != 명언이 저장된 배열의 인덱스
            //삭제된 명언의 번호를 재사용하지 않음
        }
    }

    public WiseSaying[] findListDesc() {

        //유지보수가 좋다는 장점
        WiseSaying[] resultList = new WiseSaying[lastIndex];
        int resultListIndex = 0;

        for(int i = lastIndex-1; i>=0;i--) {
            resultList[resultListIndex] = wiseSayings[i];
            resultListIndex++;
        }

        return resultList; //내림차순으로 정렬된 WiseSaying 배열 반환
    }
}
