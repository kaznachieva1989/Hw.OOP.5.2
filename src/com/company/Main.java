package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        Semaphore semaphore = new Semaphore(4, true);

        for (int i = 1; i <= 100; i++) {
            new Bus_station(i, semaphore, countDownLatch).start();
        }
        countDownLatch.await();
        System.out.println("Автобус уехал");
    }
}
