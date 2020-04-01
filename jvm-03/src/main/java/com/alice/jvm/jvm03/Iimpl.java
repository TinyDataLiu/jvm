package com.alice.jvm.jvm03;

public class Iimpl implements I {

    @Override
    public String m() {
        return "================";
    }


    public String a() {
        return i.m();
    }
}
