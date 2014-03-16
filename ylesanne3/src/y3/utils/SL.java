package y3.utils;

public class SL {
    public static void info(String message) {
        writeLog("[INFO] " + message);
    }
    public static void message(String message) {
        writeLog("[MSG] " + message);
    }

    private static void writeLog(String message) {
        message = "[" +Thread.currentThread().getName() + "] " + message;
        System.out.println(message);
    }
}
