package com.threads.concurrent.task1;

import org.junit.jupiter.api.Test;

/**
 * 3. Прерывание нити [#1019]
 */
public class ThreadStopTest {

    @Test
    public void threadStopTest() throws InterruptedException {
        var thread = new Thread(
                new ConsoleProgress()
        );
        thread.start();
        thread.join();
        thread.interrupt();
    }

}
