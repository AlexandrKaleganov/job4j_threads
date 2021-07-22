package com.threads.concurrent.task1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class ConcurrentOutput {

    @Test
    public void testThread() {
        new Thread(() -> log.info(Thread.currentThread().getName())).start();
        new Thread(() -> log.info(Thread.currentThread().getName())).start();
        log.info(Thread.currentThread().getName());
    }

}
