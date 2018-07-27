package GuardedSuspension.A36;

/**
 * 约10秒后调用interrupt方法的Main类
 */
public class Main {
    public static void main(String[] args) {
        //启动线程
        RequestQueue requestQueue = new RequestQueue();
        Thread alice = new ClientThread(requestQueue, "Alice", 314159L);
        Thread bobby = new ServerThread(requestQueue, "Bobby", 265358L);
        alice.start();
        bobby.start();
        //等待约10秒
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        //调用interrupt方法
        System.out.println("**** calling interrupt******");
        alice.interrupt();
        bobby.interrupt();
    }
}