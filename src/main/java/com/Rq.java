package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
    private Map<String, String> paramMap;
    private String actionName;

    public Rq(String command) {
        paramMap = new HashMap<>();

        String[] commandBits = command.split("\\?");

        actionName = commandBits[0];

        String queryString = commandBits.length > 1 ? commandBits[1] : "";

        String[] queryStringBits = queryString.split("&");

        paramMap = Arrays.stream(queryStringBits)
                .map(part -> part.split("="))
                .filter(bits -> bits.length == 2 && !bits[1].isEmpty() && !bits[0].isEmpty())
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

    private String getParam(String key, String defaultValue) {
        return paramMap.getOrDefault(key, defaultValue);
    }

    public int getParamAsInt(String key, int defaultValue) {
        String value = getParam(key, null);
        if(value==null){
            return defaultValue;
        }
        return Integer.parseInt(value);
    }
}
