package com.back.WiseSaying.service;

import com.back.WiseSaying.model.WiseSaying;
import com.back.WiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {
    WiseSayingRepository repo = new WiseSayingRepository();


    public int getCurrentIndex()
    {
        return repo.currentIndex();
    }
    public WiseSaying findById(int id)
    {
        return repo.findById(id);
    }

    public void change(int id, String author, String content)
    {
        WiseSaying say = new WiseSaying(id, author, content);
        repo.Change(id, say);
    }

    public boolean delete(int id)
    {
        if(repo.findById(id).isDelete)
        {
            return false;
        }
        else
        {
            repo.delete((id));
            return true;
        }
    }

    public void exit()
    {
        System.exit(0);
    }

    public WiseSaying register(WiseSaying say)
    {
        say.id = repo.currentIndex() + 1;
        return repo.save(say);
    }
}
