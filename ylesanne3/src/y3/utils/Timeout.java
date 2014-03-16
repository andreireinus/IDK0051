package y3.utils;

import java.util.concurrent.TimeUnit;

public class Timeout {
    public static void onPlayerMove() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(10);
    }
}
