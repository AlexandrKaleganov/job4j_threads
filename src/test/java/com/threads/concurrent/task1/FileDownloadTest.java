package com.threads.concurrent.task1;

import static java.lang.Thread.sleep;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The type Thread sleep.
 */
@Log4j2
@DisplayName("4. Скачивание файла с ограничением. [#144271]")
public class FileDownloadTest {

    @SneakyThrows
    @SuppressWarnings("BusyWait")
    @Test
    public void fileDownloadTest() {
        var remoteFile = "1/2/3/4/5/6/7/8/9/1/2/0/0/00/0/0/0/0/00/00/end";
        var fileResult = new StringBuilder();
        var tread = new Thread(() -> {
            var byteRead = "";
            var i = 0;
            while (remoteFile.length() > i) {
                byteRead = remoteFile.substring(i, ++i);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
                fileResult.append(byteRead);
            }
        });
        tread.start();
        tread.join();
        tread.interrupt();
        Assertions.assertEquals(remoteFile, fileResult.toString());
    }

}
