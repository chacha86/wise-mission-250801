package com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static StringUtil stringUtil = new StringUtil();

    public static void main(String[] args) {
        RunApp();
    }

    public static void RunApp() {
        stringUtil.PrintString(Constant.APP_NAME);

        Scanner scanner = new Scanner(System.in);

        ArrayList<WiseSayingDto> wiseSayingObjects = new ArrayList<>();

        int count = 1;

        while(true) {
            stringUtil.PrintString(Constant.APP_COMMAND, false);
            String command = stringUtil.ScanString(scanner);

            if (command.equals(Constant.COMMAND_ADD)) {
                AddItem(scanner, count, wiseSayingObjects);
                count++;
            } else if(command.equals(Constant.COMMAND_LIST)) {
                ShowItems(wiseSayingObjects);
            } else if(command.contains(Constant.COMMAND_DELETE)) {
                DeleteItem(command, wiseSayingObjects);
            } else if(command.contains(Constant.COMMAND_EDIT)) {
                EditItem(command, scanner, wiseSayingObjects);
            } else if(command.equals(Constant.COMMAND_QUIT)) {
                break;
            }
        }
    }

    public static void AddItem(Scanner scanner, int count, ArrayList<WiseSayingDto> wiseSayingObjects) {
        String validatedWiseSaying;
        String validatedAuthor;

        while(true){
            stringUtil.PrintString("%s : ".formatted(Constant.WISE_SAYING), false);
            String wiseSaying = stringUtil.ScanString(scanner);
            if(!wiseSaying.equals("")) {
                validatedWiseSaying = wiseSaying;
                break;
            }
        }

        while(true) {
            stringUtil.PrintString("%s : ".formatted(Constant.AUTHOR), false);
            String author = stringUtil.ScanString(scanner);
            if (!author.equals("")) {
                validatedAuthor = author;
                break;
            }
        }

        wiseSayingObjects.add(new WiseSayingDto(count, validatedAuthor, validatedWiseSaying));

        System.out.println("%d%s".formatted(count, Constant.NOTE_ADDITION));
    }

    public static void ShowItems(ArrayList<WiseSayingDto> wiseSayingObjects) {
        stringUtil.PrintString("%s / %s / %s".formatted(Constant.NUMBER, Constant.AUTHOR, Constant.WISE_SAYING));
        stringUtil.PrintString(Constant.LINE);

        for (WiseSayingDto wiseSayingObject : wiseSayingObjects) {
            stringUtil.PrintString("%s / %s / %s".formatted(wiseSayingObject.GetNumber(), wiseSayingObject.GetAuthor(), wiseSayingObject.GetWiseSaying()));
        }
    }

    public static void DeleteItem(String command, ArrayList<WiseSayingDto> wiseSayingObjects) {
        String splitCommands[] = command.split("=");
        int removeId = Integer.parseInt(splitCommands[1]);
        int index = 0;
        int removeIndex = -1;

        for (WiseSayingDto wiseSayingObject : wiseSayingObjects) {
            if (wiseSayingObject.GetNumber() == removeId) {
                removeIndex = index;
                break;
            }
            index++;
        }

        if (removeIndex < 0) {
            stringUtil.PrintString("%d%s".formatted(removeId, Constant.NOTE_NOT_FOUND_ITEM));
            return;
        }

        wiseSayingObjects.remove(removeIndex);
        stringUtil.PrintString("%d%s".formatted(removeId, Constant.NOTE_DELETE_ITEM));
    }

    public static void EditItem(String command, Scanner scanner, ArrayList<WiseSayingDto> wiseSayingObjects) {
        String splitCommands[] = command.split("=");
        int editId = Integer.parseInt(splitCommands[1]);
        int index = 0;
        int editIndex = -1;
        String originalWiseSaying = "";
        String originalAuthor = "";
        String validatedWiseSaying;
        String validatedAuthor;

        for (WiseSayingDto wiseSayingObject : wiseSayingObjects) {
            if (wiseSayingObject.GetNumber() == editId) {
                editIndex = index;
                originalWiseSaying = wiseSayingObject.GetWiseSaying();
                originalAuthor = wiseSayingObject.GetAuthor();
                break;
            }
            index++;
        }

        if (editIndex < 0) {
            stringUtil.PrintString("%d%s".formatted(editId, Constant.NOTE_NOT_FOUND_ITEM));
            return;
        }

        stringUtil.PrintString("%s : %s".formatted(Constant.WISE_SAYING_ORIGINAL, originalWiseSaying));
        while(true){
            stringUtil.PrintString("%s : ".formatted(Constant.WISE_SAYING), false);
            String wiseSaying = stringUtil.ScanString(scanner);
            if(!wiseSaying.equals("")) {
                validatedWiseSaying = wiseSaying;
                break;
            }
        }

        stringUtil.PrintString("%s : %s".formatted(Constant.AUTHOR_ORIGINAL, originalAuthor));
        while(true) {
            stringUtil.PrintString("%s : ".formatted(Constant.AUTHOR), false);
            String author = stringUtil.ScanString(scanner);
            if (!author.equals("")) {
                validatedAuthor = author;
                break;
            }
        }

        wiseSayingObjects.set(editIndex, new WiseSayingDto(editId, validatedAuthor, validatedWiseSaying));
    }
}
