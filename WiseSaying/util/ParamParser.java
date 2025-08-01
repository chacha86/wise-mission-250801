package com.back.WiseSaying.util;

import java.util.HashMap;
import java.util.Map;

public class ParamParser {
    public static Map<String, String> parse(String query) {
        Map<String, String> map = new HashMap<>();
        if (query == null || query.isEmpty()) return map;

        for (String pair : query.split("&")) {
            String[] kv = pair.split("=", 2);
            if (kv.length == 2) {
                map.put(kv[0], kv[1]);
            }
        }
        return map;
    }
}
