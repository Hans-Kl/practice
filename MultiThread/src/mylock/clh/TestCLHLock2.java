package mylock.clh;

import mylock.CLHLock;

/**
 * <p>2020/10/14 11:07</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestCLHLock2 {
    private static final CLHLock2 lock = new CLHLock2();
    private static final Runnable r = () -> {
        System.out.println(Thread.currentThread().getName() + "start");
        CLHLock.CLHNode clhNode = new CLHLock.CLHNode();
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        lock.lock();
        System.out.println("try relock");
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + "over");
    };

    public static void main(String[] args) throws InterruptedException {
        long beginMills = System.currentTimeMillis();
        testSpinLock();
        System.out.println(System.currentTimeMillis() - beginMills);
    }

    private static void testSpinLock() throws InterruptedException {
        Thread t1 = new Thread(r, "t1");
//        Thread t2 = new Thread(r, "t2");
//        Thread t3 = new Thread(r, "t3");
//        Thread t4 = new Thread(r, "t4");
        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
        t1.join();
//        t2.join();
//        t3.join();
//        t4.join();
    }
}
