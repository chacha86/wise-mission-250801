package com.back.WiseSaying.repository;
import com.back.WiseSaying.model.WiseSaying;

import java.util.LinkedHashMap;
import java.util.Map;

public class WiseSayingRepository {
    private Map<Integer, WiseSaying> wiseSayingMap = new LinkedHashMap<>();
    private int nextId = 1;

    public WiseSaying save(WiseSaying say) {
        wiseSayingMap.put(nextId, say);
        nextId++;
        return say;
    }

    public WiseSaying findById(int id) {
        return wiseSayingMap.get(id);
    }

    public void delete(int id) {
        wiseSayingMap.get(id).isDelete = true;
    }

    public void Change(int id, WiseSaying say) {
        wiseSayingMap.get(id).content = say.content;
        wiseSayingMap.get(id).author  = say.author;

    }


    public Map<Integer, WiseSaying> findAll() {
        return wiseSayingMap;
    }

    public int currentIndex() {
        return nextId - 1;
    }

}
