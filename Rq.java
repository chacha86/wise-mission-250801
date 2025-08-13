package com.back;

public class Rq {

    private String actionName;
    int targetId;

    public Rq(String command){

        String[] commandBits = command.split("\\?");

        this.actionName = commandBits[0];
        this.targetId = Integer.parseInt(commandBits[1].split("=")[1]);
    }

    int getId(String param, int defaultVaulue){
        return targetId;
    }
}
