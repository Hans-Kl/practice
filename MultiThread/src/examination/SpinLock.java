package examination;

import mylock.Lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁实现,不可重入,非公平
 * <p>2020/10/13 13:27</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class SpinLock implements Lock {
    private AtomicReference<Thread> currentThread = new AtomicReference<>();

    @Override
    public void lock() {
        while (!currentThread.compareAndSet(null, Thread.currentThread())) {
        }
//        System.out.println(Thread.currentThread().getName() + "acquire");
    }

    @Override
    public void unlock() {
        currentThread.compareAndSet(Thread.currentThread(), null);
//        System.out.println(Thread.currentThread().getName() + "release");
    }
}
