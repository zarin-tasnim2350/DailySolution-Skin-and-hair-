package com.example.test;

public class cart {
    private String code;
    private String number;


    public cart(String code,String number) {
        this.code = code;
        this.number=number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
