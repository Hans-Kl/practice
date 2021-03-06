package examination.abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 信号丢失问题
 */
public class PrintABC2 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        // 使用ReentrantLock的newCondition()方法创建三个Condition
        // 分别对应A、B、C三个线程
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        // A线程
        Thread a = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                // 叫醒B线程
                conditionB.signal();
                // 本线程阻塞
                conditionA.await();
                }
                // 这里有个坑，要记得在循环之后调用signal()，否则线程可能会一直处于
                // wait状态，导致程序无法结束
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 在finally代码块调用unlock方法
                lock.unlock();
            }
        }, "A");
        // B线程
        Thread b = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                conditionC.signal();
                conditionB.await();
                }
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B");
        // C线程
        Thread c = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                conditionA.signal();
                conditionC.await();
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C");

        c.start();
        b.start();
        a.start();
    }
}