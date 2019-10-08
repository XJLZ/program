package com.exception;

public class SysException extends Exception {

    private String msg;

    public SysException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
