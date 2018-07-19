package Introduction1.PrintThread;

/**
 * 表示输出10000次指定字符串的线程的类PrintThread
 */
public class PrintThread extends Thread {
    private String message;

    public PrintThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(message);
        }
    }
}
