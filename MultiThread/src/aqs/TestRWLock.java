package aqs;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>2020/10/15 17:06</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestRWLock {
    public static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    static Runnable rr = () -> {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "read start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "read end");
        lock.readLock().unlock();
    };

    static Runnable rw = () -> {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "write start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "write end");
        lock.writeLock().unlock();
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(rr,"rt1");
        Thread t2 = new Thread(rr,"rt2");
        Thread t3 = new Thread(rr,"rt3");
        Thread t4 = new Thread(rr,"rt4");
        Thread t5 = new Thread(rr,"rt5");
        Thread t6 = new Thread(rw,"wt6");
        Thread t7 = new Thread(rw,"wt7");
        Thread t8 = new Thread(rw,"wt8");
        Thread t9 = new Thread(rw,"wt9");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
    }
}
