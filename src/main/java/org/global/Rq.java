package org.global;

public class Rq {
    private String actionName;
    private int queryId;

    public Rq(String command) {
        String[] commandBits = command.split("\\?");
        actionName = commandBits[0];
        String queryString = commandBits.length > 1 ? commandBits[1] : "";

        String[] queryBits = queryString.split("=");
        queryId = queryBits.length > 1 ? Integer.parseInt(queryBits[1]) : -1;
    }

    public String getActionName() {
        return actionName;
    }

    public int getQueryId() {
        return queryId;
    };
}
