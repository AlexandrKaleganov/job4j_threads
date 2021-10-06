package com.threads.concurrent.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 3. Прерывание нити [#1019]
 */
@DisplayName("3. Прерывание нити [#1019], 3.1. Прерывание блокированной нити. [#267413]")
public class ThreadStopTest {

    @Test
    public void threadStopTest() throws InterruptedException {
        var thread = new Thread(
                new ConsoleProgress()
        );
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join();
    }

}
