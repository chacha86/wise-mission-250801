package org.example.domain.wiseSaying.golbal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//사용자의 명령어에서 행동과 파라미터를 분리하는 클래스
public class Rq {

    private Map<String, String> paramMap;
    private String actionName;

    public Rq(String command) {
        paramMap = new HashMap<>();

        String[] commandBits = command.split("\\?");

        actionName = commandBits[0];
        String queryString = "";

        if (commandBits.length > 1) {
            queryString = commandBits[1];
        }

        String[] queryStringBits = queryString.split("&");

        paramMap = Arrays.stream(queryStringBits)
                .map(part -> part.split("="))
                .filter(bits -> bits.length == 2 && bits[0] != null && bits[1] != null) //[key,value]
                .collect(
                        Collectors.toMap(
                                bits -> bits[0],
                                bits -> bits[1]
                        )
                );
    }

    public String getActionName() {
        return actionName;
    }

    public String getParam(String key, String defaultValue) {
        return paramMap.getOrDefault(key, defaultValue);
    }

    public int getParamAsInt(String key, int defaultValue) {
        String value = getParam(key, null);
        if (value == null) {
            return defaultValue;
        }

        return Integer.parseInt(value);
    }
}