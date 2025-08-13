package com.back;

import java.util.*;

public class App {

    private Scanner sc = new Scanner(System.in);
    private int lastNo = 0; //마지막 등록번호
    private List<WiseSaying> sayingList = new ArrayList<>();
    private WiseSaying sa;  //사용자 입력값을 받을 WiseSaying 객체

    public void run(){

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String command = sc.nextLine();   //ctrl + alt + v

            Rq rq = new Rq(command);    //여기서 명령을 받음
            String actionName = rq.getActionName();

            if(command.equals("등록")){
                actionWrite();  //등록
            }else if(command.equals("종료")){
                break;
            }else if(command.equals("목록")){
                actionList();   //목록
            }else if(command.startsWith("삭제")){ //startWith()을 쓰면 "삭제~"처럼 앞에 삭제만 있으면 true
                actionDelete(rq); //삭제

            }else if(command.startsWith("수정")){
                actionUpdate(rq);
            }
        }
    }
    private void actionUpdate(Rq rq) {
        String id = rq.getParam("id", "0");

        if(id.equals("0")){//잘못된 삭제 입력에 대한 예외처리
            System.out.println("번호를 입력해주세요.");
            return;
        }

        int target_id = Integer.parseInt(id);

        if(!update(target_id)){
            System.out.println(target_id+"번 명언은 존재하지 않습니다.");
        }
    }

    private boolean update(int target_id){
        for(WiseSaying wiseSaying : sayingList){
            if(wiseSaying.getId()==target_id){
                System.out.println("명언(기존) : "+wiseSaying.getSaying());
                System.out.print("명언 : ");
                wiseSaying.setSaying(sc.nextLine());
                System.out.println("작가(기존) : "+wiseSaying.getAuthor());
                System.out.print("작가 : ");
                wiseSaying.setAuthor(sc.nextLine());

                return true;
            }
        }
        return false;
    }

    private void actionDelete(Rq rq) {   //삭제(상호작용 부분)

        String id = rq.getParam("id", "0");

        if(id.equals("0")){//잘못된 삭제 입력에 대한 예외처리
            System.out.println("번호를 입력해주세요.");
            return;
        }

        int target_id = Integer.parseInt(id);

        if(delete(target_id)){
            System.out.println(target_id + "번 명언이 삭제되었습니다.");
        }else{
            //삭제할 id에 대한 명언이 없는경우
            System.out.println(target_id + "번 명언이 존재하지 않습니다.");
        }
    }

    private boolean delete(int index) { //삭제(데이터 처리부분)
        for (WiseSaying wiseSaying : sayingList) {
            //명언의 id로 판별해서 삭제해야함
            if(index == wiseSaying.getId()){
                sayingList.remove(wiseSaying);
                return true;
            }
        }
        //리스트를 다 찾아봤지만 삭제하지 못한경우
        return false;

        //인덱스로 삭제하는 방법은 인덱스 길이가 계속 달라져서 안됨(인덱스 != 명언id 이기 때문에 생기는 문제)
        //sayingList.remove(index-1);   //0번 인덱스의 리스트 삭제
    }

    private void actionWrite(){  //등록(사용자와 상호작용 부분)

        System.out.print("명언 : ");
        String input_saying = sc.nextLine();

        System.out.print("작가 : ");
        String input_author = sc.nextLine();

        WiseSaying result = write(input_saying, input_author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastNo));

    }

    private WiseSaying write(String input_saying, String input_author){  //등록(데이터 처리부분)
        lastNo++;
        sa = new WiseSaying(lastNo, input_saying, input_author);
        sayingList.add(sa);

        return sa;
    }

    private void actionList() {   //목록
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> reversed_list = new ArrayList<>(sayingList);   //복사
        Collections.reverse(reversed_list); //역순으로 리스트를 만들어줌

        for (WiseSaying wiseSaying : reversed_list) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getSaying());
        }
    }

}
