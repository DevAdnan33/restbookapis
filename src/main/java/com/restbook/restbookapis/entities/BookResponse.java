package com.restbook.restbookapis.entities;

public class BookResponse {
    private String msg;
    private Boolean mBoolean;

    public BookResponse(String msg, Boolean mBoolean) {
        this.msg = msg;
        this.mBoolean = mBoolean;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
