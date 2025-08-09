package org.example.domain.wiseSaying.service;

import org.example.domain.wiseSaying.entity.WiseSaying;
import org.example.domain.wiseSaying.golbal.AppContext;
import org.example.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {
        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);


        wiseSayingRepository.save(wiseSaying);
    }

    public WiseSaying write(String saying, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, saying, author);
        wiseSayingRepository.save(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayingRepository.findListDesc();
    }
    public  WiseSaying getByIdOrNull(int id){
        return wiseSayingRepository.findByIdOrNull(id);
    }
    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }

}
