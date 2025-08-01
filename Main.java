package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("== 명언 앱 ==");
        int count = 1;
        Map<Integer, String[]> hm = new HashMap<>();
        while(true){
            System.out.print("명령) ");
            String order = br.readLine();
            if(order.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = br.readLine();
                System.out.print("작가 : ");
                String author = br.readLine();
                System.out.println(count + "번 명언이 등록되었습니다.");
                hm.put(count, new String[]{author, wiseSaying});
                count++;
            } else if(order.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (Integer key : hm.keySet()) {
                    System.out.println(key + " / "  + hm.get(key)[0] +  " / " + hm.get(key)[1]);
                }
            } else if(order.startsWith("삭제?id=")) {
                int id = Integer.parseInt(order.split("=") [1]);
                if(hm.containsKey(id)){
                    hm.remove(id);
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            } else if(order.startsWith("수정?id=")) {
                int id = Integer.parseInt(order.split("=") [1]);
                if(hm.containsKey(id)){
                    System.out.println("명언(기존) : " + hm.get(id)[1]);
                    System.out.print("명언 : ");
                    String changedWiseSaying = br.readLine();
                    hm.put(id, new String[]{hm.get(id)[0], changedWiseSaying});
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            } else if (order.equals("종료")) {
                break;
            }
        }
    }
}