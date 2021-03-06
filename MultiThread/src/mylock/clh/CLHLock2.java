package mylock.clh;

import mylock.Lock;

import java.util.concurrent.atomic.AtomicReference;

public class CLHLock2 implements Lock {
    // 尾巴，是所有线程共有的一个。所有线程进来后，把自己设置为tail
    private final AtomicReference<QNode> tail;
    // 前驱节点，每个线程独有一个。
    private final ThreadLocal<QNode> myPred;
    // 当前节点，表示自己，每个线程独有一个。
    private final ThreadLocal<QNode> myNode;

    public CLHLock2() {
        this.tail = new AtomicReference<QNode>(new QNode());
        this.myNode = ThreadLocal.withInitial(QNode::new);
        this.myPred = new ThreadLocal<QNode>();
    }

    @Override
    public void lock() {
        // 获取当前线程的代表节点
        QNode node = myNode.get();
        // 将自己的状态设置为true表示获取锁。
        node.locked = true;
        // 将自己放在队列的尾巴，并且返回以前的值。第一次进将获取构造函数中的那个new lock.clh.QNode
        QNode pred = tail.getAndSet(node);
        // 把旧的节点放入前驱节点。
        myPred.set(pred);
        // 判断前驱节点的状态，然后走掉。
        while (pred.locked) {
        }
    }

    @Override
    public void unlock() {
        // unlock. 获取自己的node。把自己的locked设置为false。
        QNode node = myNode.get();
        node.locked = false;
//        myNode.set(new QNode());
        myNode.set(myPred.get());
    }
}