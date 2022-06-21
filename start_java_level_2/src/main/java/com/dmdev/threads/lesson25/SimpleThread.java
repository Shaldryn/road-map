package com.dmdev.threads.lesson25;

public class SimpleThread extends Thread {

    @Override
    public void run() {
//        System.out.println("Hello " + Thread.currentThread().getName());
        System.out.println("Hello " + getName());
    }
}
