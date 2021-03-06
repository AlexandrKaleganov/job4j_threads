package com.threads.concurrent.task1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 * The type Thread state test.
 */
@Log4j2
public class ThreadStateTest {

    /**
     * 1.1. Состояние нити. [#229175 #180638].
     */
    @Test
    public void testState() {
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
        while (first.getState() != Thread.State.TERMINATED || two.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getState());
            System.out.println(two.getState());
        }
        log.info(first.getState());
        log.info(two.getState());
        log.info("Работа завершена.");
    }

}
