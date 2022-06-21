package com.dmdev.threads.lesson25.queue;

import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {

    private final BlockingQueue<CashBox> cashBoxes;

    public BuyerThread(BlockingQueue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            CashBox cashBox = cashBoxes.take();
            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashBox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashBox);
            cashBoxes.add(cashBox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //without concurrent
//    private final Queue<CashBox> cashBoxes;
//
//    public BuyerThread(Queue<CashBox> cashBoxes) {
//        this.cashBoxes = cashBoxes;
//    }
//
//    @Override
//    public void run() {
//        try {
//            synchronized (cashBoxes) {
//                while (true) {
//                    if (!cashBoxes.isEmpty()) {
//                        CashBox cashBox = cashBoxes.remove();
//                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashBox);
//
////                        Thread.sleep(5L);
//                        cashBoxes.wait(5L);
//
//                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashBox);
//                        cashBoxes.add(cashBox);
//                        cashBoxes.notifyAll();
//                        break;
//                    } else {
//                        System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу ");
////                        Thread.sleep(5L);
//                        cashBoxes.wait();
//                    }
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
