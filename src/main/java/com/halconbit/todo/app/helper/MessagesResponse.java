package com.halconbit.todo.app.helper;

public enum MessagesResponse {
    OK("ok"),
    CREATE("resource created successfully"),
    SUCCESS("success"),
    UPDATE("resource updated successfully"),
    DELETE("resource deleted successfully"),
    ARCHIVE("resource archived successfully"),
    LIST("list of"),
    EMAIL("check email"),
    ;

    private final String value;

    MessagesResponse(String value) {
        this.value = value;
    }

    public String Of(String ofComplement) {
        return this.getValue() + " " + ofComplement;
    }

    public String getValue() {
        return value;
    }


}