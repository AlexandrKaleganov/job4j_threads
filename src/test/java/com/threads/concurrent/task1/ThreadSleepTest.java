package com.threads.concurrent.task1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 * The type Thread sleep.
 */
@Log4j2
public class ThreadSleepTest {

    /**
     * Sleep test.
     *
     * @throws InterruptedException
     *         the interrupted exception
     */
    @Test
    public void sleepTest() throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    try {
                        System.out.println("Start loading ... ");
                        for (int i = 0; i < 110; i = i + 10) {
                            System.out.print("\rLoading : " + i + "%");
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        log.error(e.getMessage(), e);
                    }
                }
        );
        thread.start();
        thread.join();
        System.out.println("Main");
    }

}
