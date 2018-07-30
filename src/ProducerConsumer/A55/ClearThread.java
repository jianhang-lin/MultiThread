package ProducerConsumer.A55;

/**
 * 每隔约1秒调用一次clear的ClearThread类
 */
public class ClearThread extends Thread {
    private final Table table;

    public ClearThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println("======" + getName() + " clears =====");
                table.clear();
            }
        } catch (InterruptedException e){}
    }
}
