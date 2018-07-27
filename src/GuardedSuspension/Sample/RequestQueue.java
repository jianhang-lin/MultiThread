package GuardedSuspension.Sample;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 依次存放请求的类
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest() {
        while (queue.peek() == null) {//守护条件的逻辑非运算
            try {
                System.out.println(Thread.currentThread().getName() + ": wait() begins, queue = " + queue);
                wait();
                System.out.println(Thread.currentThread().getName() + ": wait() ends, queue = " + queue);
            } catch (InterruptedException e) {

            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        //即使先执行notifyAll，RequestQueue类也会安全运行.
        //在执行notifyAll时，参数request还没有添加到queue中.不过，由于执行notifyAll的线程持有着this的锁，所以执行notifyAll之后，从等待队列
        //中退出的其他线程在获取锁时阻塞.因此，其他线程的操作实际上并没有什么进展（也不会检查守护条件）.
        //而执行notifyAll的线程会在执行offer之后 ，从putRequest返回.这时，this的锁才会被释放.之后，阻塞中的其他线程（之一）会获取this的锁，
        //继续执行操作（首先会检查守护条件）.
        //因此，无论putRequest中两条语句的顺序如何，RequestQueue类都能安全运行.
        queue.offer(request);
        System.out.println(Thread.currentThread().getName() + ":notifyAll() begins, queue = " + queue);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ":notifyAll() ends, queue = " + queue);
    }
}
