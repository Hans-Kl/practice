package examination.abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>2020/10/16 10:50</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestCondition {
    public static final ReentrantLock LOCK = new ReentrantLock();
    public static final Condition CONDITION = LOCK.newCondition();
    private static int COUNT = 0;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            LOCK.lock();
            for (int i = 0; i < 10; i++) {
                while (!(COUNT % 3 == 0)) {
                    try {
                        CONDITION.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("a");
                COUNT++;
                CONDITION.signalAll();
            }
            LOCK.unlock();
        });

        Thread b = new Thread(() -> {
            LOCK.lock();
            for (int i = 0; i < 10; i++) {
                while (!(COUNT % 3 == 1)) {
                    try {
                        CONDITION.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("b");
                COUNT++;
                CONDITION.signalAll();
            }
            LOCK.unlock();
        });

        Thread c = new Thread(() -> {
            LOCK.lock();
            for (int i = 0; i < 10; i++) {
                while (!(COUNT % 3 == 2)) {
                    try {
                        CONDITION.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i + "c");
                COUNT++;
                CONDITION.signalAll();
            }
            LOCK.unlock();
        });
        c.start();
        b.start();
        a.start();

    }
}
