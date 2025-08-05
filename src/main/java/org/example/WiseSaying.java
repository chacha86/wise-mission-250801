package org.example;

import org.json.JSONObject;

public class WiseSaying {
    public String content;
    public String author;
    public int num;
    public WiseSaying(int num,String content,String author){
        this.num=num;
        this.content=content;
        this.author=author;
    }
    public JSONObject toJsonObject() {
        JSONObject obj = new JSONObject();
        obj.put("num", num);
        obj.put("content", content);
        obj.put("author", author);
        return obj;
    }
    public static WiseSaying fromJsonObject(JSONObject obj) {
        int num = obj.getInt("num");
        String content = obj.getString("content");
        String author = obj.getString("author");
        return new WiseSaying(num, content, author);
    }

}