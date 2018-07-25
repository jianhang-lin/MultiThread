package SingleThreadedExecution.A17b;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 改良了的Mutex类
 */
public class Mutex {
    private long locks = 0;
    private Thread owner = null;

    public synchronized void lock() {
        Thread me = Thread.currentThread();
        while (locks > 0 && owner != me) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        assert locks == 0 || owner == me;//lock个数为0，或者自己已经lock了
        owner = me;
        locks++;
    }

    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        if (locks == 0 || owner != me) {
            return;
        }
        assert locks > 0 && owner == me;//lock个数大于0，且是自己lock的
        locks--;
        if (locks == 0) {
            owner = null;
            notifyAll();
        }
    }
}
