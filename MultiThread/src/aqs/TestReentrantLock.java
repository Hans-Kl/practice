package aqs;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>2020/10/6 19:49</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestReentrantLock {
    public static final ReentrantLock lock = new ReentrantLock(true);
    static Runnable r = () -> {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "start");
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "end");
        lock.unlock();
    };

    public static void main(String[] args) {
//        case1();
//        case2();
//        case3();
//        case4();
//        case5();
//        caseInterrupt();
        caseParkInterrupt();
    }

    static void case1() {
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    static void case2() {
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    static void case3() {
        AtomicInteger atomicInteger = new AtomicInteger();
        boolean b = atomicInteger.compareAndSet(2, 3);
        System.out.println(b);
        System.out.println("end");
    }

    static void case4() {
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(t1::interrupt);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    static void caseLoopShouldParkAfterFailedAcquire() {
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    /**
     * 测试先unpark,再park
     */
    static void case5() {
        Thread thread = new Thread(() -> {
            System.out.println("thread Start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread park");
            LockSupport.park();
            System.out.println("thread over");
        });
        thread.start();
        System.out.println(Thread.currentThread());
        System.out.println("park");
        LockSupport.unpark(thread);
        System.out.println("main over");
    }

    static void caseInterrupt() {
        Thread thread = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("thread Start");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
                System.out.println("thread park");
                LockSupport.park();
                System.out.println("thread over");
                lock.unlock();
            } catch (InterruptedException e) {
                System.out.println("------------------");
                e.printStackTrace();
            }
        });
        lock.lock();
        System.out.println(lock.getQueueLength());
        thread.start();
        System.out.println("main start");
        thread.interrupt();
//        LockSupport.unpark(thread);
        System.out.println("main over");
    }

    static void caseParkInterrupt() {
        Thread thread = new Thread(() -> {
            System.out.println("thread");
            LockSupport.park();
            System.out.println("thread over");
        });
        thread.start();
        System.out.println("main");
        thread.interrupt();
        System.out.println("main over");
    }
}
