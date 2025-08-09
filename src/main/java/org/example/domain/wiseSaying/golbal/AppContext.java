package org.example.domain.wiseSaying.golbal;

import org.example.domain.wiseSaying.controller.SystemController;
import org.example.domain.wiseSaying.controller.WiseSayingController;
import org.example.domain.wiseSaying.repository.WiseSayingRepository;
import org.example.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {
    public static Scanner sc = new Scanner(System.in);
    public static WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public static WiseSayingService wiseSayingService = new WiseSayingService();
    public static WiseSayingController wiseSayingController = new WiseSayingController(sc);
    public static SystemController systemController = new SystemController();

}
