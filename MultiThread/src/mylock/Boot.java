package mylock;

/**
 * <p>2020/10/13 13:51</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Boot {
    private static final SpinLock lock = new SpinLock();
    private static final Runnable r = () -> {
        System.out.println(Thread.currentThread().getName() + "start");
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        Thread t2 = new Thread(r, "t2");
        Thread t3 = new Thread(r, "t3");
        Thread t4 = new Thread(r, "t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

}
