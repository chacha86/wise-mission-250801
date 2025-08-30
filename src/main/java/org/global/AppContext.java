package org.global;

import org.example.controller.Controller;
import org.example.repository.Repository;
import org.example.service.Service;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner = new Scanner(System.in);
    public static Repository repository = new Repository();
    public static Service service = new Service();
    public static Controller controller = new Controller();
}
