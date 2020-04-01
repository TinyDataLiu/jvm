package com.alice.jvm;

import java.io.IOException;

/**
 * Hello world!
 */
public class Jvm02App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
