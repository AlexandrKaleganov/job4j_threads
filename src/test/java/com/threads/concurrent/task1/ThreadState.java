package com.threads.concurrent.task1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class ThreadState {

    @Test
    public void testState() throws InterruptedException {
        Thread first = new Thread(
                () -> log.info(Thread.currentThread().getName() + " " + Thread.currentThread().getState())
        );
        Thread two = new Thread(
                () -> log.info(Thread.currentThread().getName() + " " + Thread.currentThread().getState())
        );
        log.info(first.getState() + " Выведет NEW");
        log.info(two.getState() + " Выведет NEW");
        first.start();
        two.start();
        first.join();
        two.join();
        log.info(first.getState());
        log.info(two.getState());
        log.info("Работа завершена.");
    }

}
