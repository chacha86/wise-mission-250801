package com.iwon;

public enum CommandList {
    END("종료"),
    ADD("등록"),
    LIST("목록"),
    DELETE("삭제"),
    CHANGE("수정")
    ;

    private final String label;

    CommandList(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
