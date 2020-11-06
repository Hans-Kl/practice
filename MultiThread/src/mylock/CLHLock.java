package mylock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * https://coderbee.net/index.php/concurrent/20131115/577
 * clh锁实现
 */
public class CLHLock {
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> TAIL_UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(CLHLock.class, CLHNode.class, "tail");

    @SuppressWarnings("unused")
    private volatile CLHNode tail;

    public void lock(CLHNode currentThread) {
        CLHNode preNode = TAIL_UPDATER.getAndSet(this, currentThread);
        if (preNode != null) {//已有线程占用了锁，进入自旋
            while (preNode.isLocked) {
            }
        }
    }

    public void unlock(CLHNode currentThread) {
        // 如果队列里只有当前线程，则释放对当前线程的引用（for GC）。
        if (!TAIL_UPDATER.compareAndSet(this, currentThread, null)) {
            // 还有后续线程
            currentThread.isLocked = false;// 改变状态，让后续线程结束自旋
        }
    }

    public static class CLHNode {
        private volatile boolean isLocked = true; // 默认是在等待锁
    }

}