package com.alice.concurrent.bq;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liuchun
 * @date 2020/02/21  14:21
 */
@Slf4j
public class IPayWithBlockQueueDemo {

    @Data
    @Accessors(chain = true)
    class Bill {
        private String name;
        private Double amt;
    }


    private final ArrayBlockingQueue<Bill> messageQueue = new ArrayBlockingQueue<>(10);


    private void init() {
        // 启动短信发送线程监听 是否有信息需要发送
        new Thread(() -> {
            while (true) {
                try {
                    Bill bill = messageQueue.take();
                    sendMessage(bill.getName(), bill.getAmt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

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
            //将信息放入阻塞队列，由专门的负责发送信息的线程来处理信息发送的逻辑
            Bill bill = new Bill();
            bill.setAmt(amt).setName(name);
            messageQueue.put(bill);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IPayWithBlockQueueDemo iPay = new IPayWithBlockQueueDemo();
        iPay.payAndMessage(1000D, "张三");
    }
}
