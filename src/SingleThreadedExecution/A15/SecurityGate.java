package SingleThreadedExecution.A15;

/**
 * 为了让线程在counter值变化前和变化化都易于切换而修改SecurityGate类
 */
public class SecurityGate {
    private int counter = 0;

    public void enter() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter + 1;
    }

    public void exit() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter - 1;
    }

    public int getCounter() {
        return counter;
    }
}
