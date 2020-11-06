package blockqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>2020/10/26 16:52</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestSynchronousQueue {
    static SynchronousQueue<Integer> queue = new SynchronousQueue<>();
    static Thread t = new Thread(() -> {
        Integer take = queue.poll();
        System.out.println(take);
    });

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
        t.start();
        queue.offer(1);

        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
        queue.offer(2);
        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
        System.out.println(queue.size());
    }
}
