package org.example.repository;

import org.example.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public int save(WiseSaying wiseSaying) {
        lastId++;
        wiseSaying.setId(lastId);
        wiseSayings.add(wiseSaying);

        return lastId;
    }

    public List<WiseSaying> list() {
        return wiseSayings;
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayings.stream()
                .filter(w -> w.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void delete(int id) {
        wiseSayings.removeIf(w -> w.getId() == id);
    }
}
