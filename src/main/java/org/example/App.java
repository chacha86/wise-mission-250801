package org.example;

import java.util.List;
import java.util.Scanner;

public class App {



    List<WiseSaying> list = FileUtil.loadList();;
    int count = FileUtil.loadLastId();
    String command;
    Scanner sc = new Scanner(System.in);

    public void run(){

        System.out.println("== 명언 앱==");

        while (true) {
            System.out.print("명령)");
            command=sc.nextLine();
            if(command.equals("등록")) {
                actionWrite();
            } else if(command.equals("목록")){
                actionList();
            } else if (command.startsWith("삭제?id=")) {
                actionDelete();
            }else if (command.startsWith("수정?id=")) {
                actionModify();
            } else if (command.equals("빌드")) {
                FileUtil.saveList(list);
                FileUtil.saveLastId(count);
                System.out.println("data.json 파일의 내용이 갱신되었습니다.");
            } else if(command.equals("종료")) break;
        }
    }

    public void actionWrite(){
        System.out.print("명언 : ");
        String content=sc.nextLine();
        System.out.print("작가 : ");
        String author=sc.nextLine();
        count++;
        WiseSaying ws = new WiseSaying(count, content, author);
        list.add(ws);
        FileUtil.saveList(list);
        FileUtil.saveLastId(count);
        System.out.println(count + "번 명언이 등록되었습니다.");
    }

    public void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for(WiseSaying ws:list){
            System.out.println("%d / %s / %s " .formatted(ws.num,ws.author,ws.content));
        }
    }

    public void actionDelete(){
        String[] com=command.split("=");
        if(com.length==2) {
            int num = Integer.parseInt(com[1]);
            boolean check =false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).num==num) {
                    list.remove(i);
                    System.out.println(num + "번 명언이 삭제되었습니다.");
                    check=true;
                    break;
                }
            }
            if(!check){
                System.out.println(num+"번 명언은 존재하지 않습니다.");
            }
        }
    }

    public void actionModify(){
        String[] com=command.split("=");
        if(com.length==2) {
            int num = Integer.parseInt(com[1]);
            boolean check =false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).num==num) {
                    System.out.println("명언(기존) : " + list.get(i).content);
                    System.out.print("명언 : ");
                    list.get(i).content=sc.nextLine();
                    System.out.println("작가(기존) : " + list.get(i).author);
                    System.out.print("작가 : ");
                    FileUtil.saveList(list);
                    System.out.println(num + "번 명언이 수정되었습니다.");
                    check=true;
                }
            }
            if(!check){
                System.out.println(num+"번 명언은 존재하지 않습니다.");
            }
        }
    }


}
