package examination.abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>2020/10/16 14:06</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestMultiConditions {
    public static final ReentrantLock LOCK = new ReentrantLock();
    public static final Condition CONDITION0 = LOCK.newCondition();
    public static final Condition CONDITION1 = LOCK.newCondition();
    public static final Condition CONDITION2 = LOCK.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            LOCK.lock();
            System.out.println("a");
            CONDITION1.signalAll();
            LOCK.unlock();
        });

        Thread b = new Thread(() -> {
            LOCK.lock();
            try {
                CONDITION1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b");
            CONDITION2.signalAll();
            LOCK.unlock();
        });

        Thread c = new Thread(() -> {
            LOCK.lock();
            try {
                CONDITION2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("c");
            CONDITION0.signalAll();
            LOCK.unlock();
        });
        a.start();
        b.start();
        c.start();
    }
}
