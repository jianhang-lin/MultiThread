package SingleThreadedExecution.A15;

/**
 * 表示执行10次enter和exit的线程的类
 */
public class CrackerThread extends Thread {
    private final SecurityGate gate;

    public CrackerThread(SecurityGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            gate.enter();
            gate.exit();
        }
    }
}
