package com.back;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    List<WiseSaying> wiseSayings = new ArrayList<>();
    int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying){

        if(wiseSaying.isNew()){
            lastId++;
            wiseSaying.setId(lastId);
            wiseSayings.add(wiseSaying);
            return wiseSaying;
        }

        return wiseSaying;


    }

    boolean delete(int id){
        return wiseSayings.removeIf( (WiseSaying w) -> w.getId() == id);
    }

    public List<WiseSaying> findListDesc(){
        return wiseSayings.reversed();
    }

    public WiseSaying findByIdOrNull(int id){

        return  wiseSayings.stream()
                .filter( (WiseSaying w) -> w.getId() ==id )
                .findFirst()
                .orElse(null);
    }
}
