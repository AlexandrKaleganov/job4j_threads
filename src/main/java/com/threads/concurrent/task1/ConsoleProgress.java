package com.threads.concurrent.task1;

import lombok.SneakyThrows;

public class ConsoleProgress implements Runnable {

    @SuppressWarnings("BusyWait")
    @SneakyThrows
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted()) {
            count = count + 10;
            System.out.printf("\r load: %s %s", count, count / 10 % 2 > 0 ? "\\" : "/");
            Thread.sleep(200);
            System.out.printf("\r load: %s %s", count, "|");
            Thread.sleep(200);
            if (count >= 100) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
