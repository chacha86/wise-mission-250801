package com.back;

import java.util.HashMap;
import java.util.Map;

public class Rq {//Request라는 의미
    //고객의 요청을 받아야함

    private Map<String, String> paramMap;
    private String actionName;  //목록, 등록 등의 내용이 들어감
    private int paramAsInt;

    //목록?keywordType=content&keyword=과거&page=2
    //? 기준으로 자르고 &기준으로 자를 필요가있다. 이후 = 기준으로 잘라야한다.
    public Rq(String command) {    //고객의 요청을 command라고 함
        paramMap = new HashMap<>();

        String[] commandBits = command.split("\\?");  //문자 ?는 "\\?"로 표현한다.

        actionName = commandBits[0]; // 고객이 원하는 행동 -> 목록

        ////queryString은  명령 중 keywordType=content&keyword=과거&page=2 부분이다.
        String queryString = commandBits.length>1 ?queryString = commandBits[1] : "";

        if(commandBits.length>1) {

            String[] queryStringBits = commandBits[1].split("&");   // keywordType=content
/*
        paramMap = Arrays.stream(queryStringBits)
                    .map((String part) -> part.split("="))     //key와 value들로 쪼개졌으나 value값이 안들어온 경우도 생각해야함
                    .filter((String[] bits)->bits.length==2 && bits[0] !=null && bits[1]!=null) //쪼개진길이가 2여야하고 각각이 null이 아니어야한다는 조건
                    .collect((                  //결과(String[])를 Map으로 만들어주는 메서드이다.
                            Collectors.toMap(
                                    bits -> bits[0],
                                    bits -> bits[1]
                            )
                            ));
         //물론 스트림 안쓰고 아래 For문으로 해결하는것도 무방하다.
*/
            for (String param : queryStringBits) {
                String[] paramBits = param.split("=");
                String key = paramBits[0];  //keywordType
                String value = null;
                if (paramBits.length > 1) {   //이상하게 입력했을 경우를 방지
                    value = paramBits[1];   //content
                }
                if (value == null) {
                    continue;
                }

                paramMap.put(key, value);

            }
        }
    }

    public String getParam(String key, String defaultValue) {
        return paramMap.getOrDefault(key, defaultValue);    //key에 맞는 value가 없다면 defaultValue값을 반환해줌
    }

    public String getActionName() {
        return actionName;
    }

    //사용자가 입력한 id값을 숫자로 돌려받을때 사용
    public int getParamAsInt(String key, int defaultValue) {//없는 데이터를 요청할때 반환할 값을 사용자에게 입력받음
        //기본적으로 -1을 리턴하면 되지만 -1이 특정 상황에선 의미있는 값일수있기 때문임

        String value = getParam(key, null);

        if(value==null){    //Map에 저장한적 없는 데이터를 요청할때
            return defaultValue;
        }
        return Integer.parseInt(value);
    }

}
