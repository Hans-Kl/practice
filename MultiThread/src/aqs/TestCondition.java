package aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>2020/10/15 18:40</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestCondition {
    public static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();
    public static final Condition CONDITION1 = REENTRANT_LOCK.newCondition();
    public static final Runnable ra = () -> {
        System.out.println("a");
    };
    public static final Runnable rb = () -> {
    };
    public static final Runnable rc = () -> {
    };

    public static void main(String[] args) {
        Thread a = new Thread(ra, "a");
        Thread b = new Thread(rb, "b");
        Thread c = new Thread(rc, "c");
        a.start();
        b.start();
        c.start();
    }
}
