package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Bus_station extends Thread {
    private int id;
    Semaphore semaphore;
    private CountDownLatch countDownLatch;

    public Bus_station(int id, Semaphore semaphore, CountDownLatch countDownLatch) {
        this.id = id;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.printf("Пассажир     %d     пришел в автовокзал \n", id);
        try {
            semaphore.acquire();
            System.out.printf("Пассажир          %d          покупает билет \n", id);
            sleep(1000);
            System.out.printf("Пассажир                 %d         купил билет и ждет автобус \n", id);
            sleep(1000);
            semaphore.release();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
