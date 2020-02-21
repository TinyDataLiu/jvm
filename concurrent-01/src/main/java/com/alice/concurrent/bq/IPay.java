package com.alice.concurrent.bq;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author liuchun
 * @date 2020/02/21  14:21
 */
@Slf4j
public class IPay {

    /**
     * 支付主体
     *
     * @param amt
     */
    private void pay(Double amt) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("支付成功{}元", amt);
    }

    /**
     * 发送支付短信
     *
     * @param name
     * @param amt
     */
    private void sendMessage(String name, Double amt) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("尊敬的用户{},您支付了{}元", name, amt);
    }


    private void payAndMessage(Double amt, String name) {
        // 执行支付操作
        try {
            pay(amt);
            // 发送支付成功短信
            sendMessage(name, amt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IPay iPay = new IPay();
        iPay.payAndMessage(1000D, "张三");
    }

}
