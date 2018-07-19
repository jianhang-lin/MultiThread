package Introduction1.Printer;

/**
 * 利用Runnable接口启动两个线程
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();
    }
}
