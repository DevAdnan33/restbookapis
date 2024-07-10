package com.restbook.restbookapis.entities;

public class BookResponse {
    private String msg;
    

    public BookResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
