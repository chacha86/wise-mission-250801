package org.example.service;

import org.example.entity.WiseSaying;
import org.example.repository.Repository;
import org.global.AppContext;

import java.util.List;
import java.util.Scanner;

public class Service {
    private Scanner scanner = AppContext.scanner;
    private Repository repository = AppContext.repository;

    public int write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        return repository.save(wiseSaying);
    }

    public List<WiseSaying> list() {
        return repository.list().reversed();
    }

    public WiseSaying findByIdOrNull(int id) {
        return repository.findByIdOrNull(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public void edit(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }
}
