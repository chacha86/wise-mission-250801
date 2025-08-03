package com.back;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public boolean CheckStringValidation(String input) {
        String regex = "[^.?=a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ\\s]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return false;
        }

        return true;
    }

    public String ScanString(Scanner scanner) {
        String string = scanner.nextLine();
        if(!this.CheckStringValidation(string)) {
            this.PrintString(Constant.ALERT_STRING_VALIDATION);
            return "";
        }

        return string;
    }

    public void PrintString(String string, boolean nextLine) {
        if (nextLine) {
            System.out.println(string);
        } else {
            System.out.print(string);
        }
    }

    public void PrintString(String string) {
        System.out.println(string);
    }
}
