package com.threads.concurrent.task1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 * The type Concurrent output test.
 */
@Log4j2
public class ConcurrentOutputTest {

    /**
     * 1. Запуск нити. Thread#start() [#1016 #180630]
     */
    @Test
    public void testThread() {
        new Thread(() -> log.info(Thread.currentThread().getName())).start();
        new Thread(() -> log.info(Thread.currentThread().getName())).start();
        log.info(Thread.currentThread().getName());
    }

}
