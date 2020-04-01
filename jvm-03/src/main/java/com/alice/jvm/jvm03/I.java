package com.alice.jvm.jvm03;

public interface I {

    String m();


    I i = new Iimpl();

    class Impl implements I {
        @Override
        public String m() {
            return "Impl";
        }
    }
}
