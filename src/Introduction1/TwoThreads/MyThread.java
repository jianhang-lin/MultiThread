package Introduction1.TwoThreads;

/**
 * 表示新线程的MyThread类
 */
public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print("Nice!");
        }
    }
}
