package aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>2020/10/24 17:43</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestInterrupt {
    public static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();
    static Thread t1 = new Thread(() -> {
        REENTRANT_LOCK.lock();
        System.out.println("t1 start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1 over");
        REENTRANT_LOCK.unlock();
    });

    static Thread t3 = new Thread(() -> {
        System.out.println("t3 start");
        REENTRANT_LOCK.lock();
        System.out.println("t3 get lock");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t3 over");
        REENTRANT_LOCK.unlock();
    });

    static Thread t2 = new Thread(() -> {
        System.out.println("t2 interrupt start");
        t3.interrupt();
        System.out.println("t2 over");
    });


    public static void main(String[] args) {
        t1.start();
        t3.start();
        t2.start();

    }
}
