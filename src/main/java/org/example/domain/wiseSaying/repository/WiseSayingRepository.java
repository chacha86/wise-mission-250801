package org.example.domain.wiseSaying.repository;

import org.example.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;


    public WiseSaying findByIdOrNull(int id) {
        return wiseSayings.stream()
                .filter(w -> w.getId() == id)
                .findFirst()
                .orElse(null);
    }public boolean delete(int id) {
        return wiseSayings.removeIf(w -> w.getId() == id);
    }

    public WiseSaying save(WiseSaying wiseSaying){

        //새로운 명언 혹은 기존 명언
        if(wiseSaying.isNew()){
            lastId++;
            wiseSaying.setId(lastId);
            wiseSaying.setCreatedDate(java.time.LocalDateTime.now());
            wiseSaying.setModifiedDate(java.time.LocalDateTime.now());
            wiseSayings.add(wiseSaying);
        }else{
            wiseSaying.setModifiedDate(java.time.LocalDateTime.now());
        }
        return wiseSaying;
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayings.reversed();
    }

}
