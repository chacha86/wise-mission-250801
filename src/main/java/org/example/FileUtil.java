package org.example;

import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static final String DB_PATH = "db/wiseSaying/wiseSayings.json";

    public static void saveList(List<WiseSaying> list){
        JSONArray arr = new JSONArray();
        for(WiseSaying ws :list){
            arr.put(ws.toJsonObject());
        }
        try{
            Files.createDirectories(Paths.get(DB_PATH).getParent());
            Files.writeString(Paths.get(DB_PATH), arr.toString(2));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<WiseSaying> loadList(){
        List<WiseSaying> list = new ArrayList<>();
        File file = new File(DB_PATH);
        if(!file.exists()) {
            System.out.println("데이터 없음");
            return list;}
        try{
            String json = Files.readString(Paths.get(DB_PATH));
            JSONArray arr = new JSONArray(json);
            for(int i = 0; i<arr.length(); i++){
                list.add(WiseSaying.fromJsonObject(arr.getJSONObject(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int loadLastId() {
        try {
            return Integer.parseInt(Files.readString(Paths.get("db/wiseSaying/lastId.txt")).trim());
        } catch (Exception e) {
            return 0;
        }
    }
    public static void saveLastId(int id) {
        try {
            Files.writeString(Paths.get("db/wiseSaying/lastId.txt"), String.valueOf(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
