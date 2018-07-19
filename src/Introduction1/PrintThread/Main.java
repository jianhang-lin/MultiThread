package Introduction1.PrintThread;

/**
 * 利用PrintThread类启动2个线程
 */
public class Main {
    public static void main(String[] args) {
        new PrintThread("Good!").start();
        new PrintThread("Nice!").start();
    }
}
