package com.alice.concurrent.bq;

import java.util.concurrent.TimeUnit;

/**
 * @author liuchun
 * @date 2020/02/21  14:09
 */
public class UserService extends MessageService {


    public static void main(String[] args) throws InterruptedException {
        UserService userService = new UserService();
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(2);
            userService.messageQueue.add("用户:" + i + "注册成功");
        }
    }
}
