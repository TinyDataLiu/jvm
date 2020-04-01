package com.alice.jvm;

/**
 * Heap GC
 * <p>
 * <p>
 * NEW
 * |
 * ------Eden----------
 * |                  |
 * |                  |
 * Y                  Minor GC ----N ----------Old(Major GC) ------N -------- All(Full GC) ----- N ----> OOM
 * |                  |                         |                                 |
 * |                  |                         |                                 |
 * |                  Y                         Y                                 Y
 * |                  |                         |                                 |
 * |                  |                         |                                 |
 * |                  |                         |                                 |
 * |                  |                         |                                 |
 * |---->Success<------------------------------------------------------------------
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
