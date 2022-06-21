package com.dmdev.threads.lesson25.task;

import java.util.Queue;

public class ProducerThread implements Runnable {

    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() < 10) {
                    int random = RandomUtil.getRandom();
                    list.add(random);
                    System.out.println("producer adds value: " + random + ". Size " + list.size());
                } else {
                    System.out.println("producer does nothing");
                }
//                list.notifyAll(); //если бы в wait выпало 0
                try {
//                    Thread.sleep(RandomUtil.getRandom()); //не освобождает наш монитор
//                    int randomWaitValue = RandomUtil.getRandom(5);
                    int randomWaitValue = 20;
                    System.out.println("producer waits: " + randomWaitValue);
                    list.wait(randomWaitValue); //вызов внутри synchronized, освобождает монитор
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
