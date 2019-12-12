package com.alice.jvm.frames;

/**
 * @author liuchun
 * @date 2019/12/12  15:33
 */
public class Frames {
    public int add(int v1, int v2) {
        int v3 = v1 + v2;
        return v3;
    }

    public int sub(int v1, int v2) {
        return v1 - v2;
    }

    public long subLong(long v1, long v2) {
        return v1 - v2;
    }
}
