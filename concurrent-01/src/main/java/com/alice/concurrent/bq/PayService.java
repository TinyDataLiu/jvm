package com.alice.concurrent.bq;

/**
 * @author liuchun
 * @date 2020/02/21  14:11
 */
public class PayService extends MessageService {

    public static void main(String[] args) throws InterruptedException {
        PayService payService = new PayService();
        for (int i = 0; i < 20; i++) {
            payService.messageQueue.put("支付场景");
        }
    }
}
