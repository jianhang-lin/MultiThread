package ProducerConsumer.A55;

/**
 * 表示桌子的类
 */
public class Table {
    private final String[] buffer;
    private int tail;//下次put的位置
    private int head;//下次take的位置
    private int count;//buffer中的蛋糕个数

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    //放置蛋糕
    //加了throws InterruptedException的方法可能会花费时间，但可以取消
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        //桌子上可以放置的蛋糕最大个数减去当前桌子上已经放置的个数，即可放置蛋糕的位置数要大于0
        while (count >= buffer.length) {
            System.out.println(Thread.currentThread().getName() + " wait BEGIN");
            wait();
            System.out.println(Thread.currentThread().getName() + " wait END");
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    //拿取蛋糕
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            System.out.println(Thread.currentThread().getName() + " wait BEGIN");
            wait();
            System.out.println(Thread.currentThread().getName() + " wait END");
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

    //清除蛋糕
    public synchronized void clear(){
        //该while语句用来表示清除的蛋糕，也可以不写
        while (count > 0) {
            String cake = buffer[head];
            System.out.println(Thread.currentThread().getName() + " clears " + cake);
            head = (head + 1) % buffer.length;
            count--;
        }
        head = 0;
        tail = 0;
        count = 0;
        notifyAll();
    }
}
