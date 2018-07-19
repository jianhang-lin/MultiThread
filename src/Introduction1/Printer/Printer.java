package Introduction1.Printer;

/**
 * 输出指定字符串的Printer类
 */
public class Printer implements Runnable{
    private String message;

    public Printer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(message);
        }
    }
}
