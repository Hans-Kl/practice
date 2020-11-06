package threadpool.pc;

import java.util.concurrent.SynchronousQueue;

/**
 * <p>2020/9/23 18:32</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestSynchronyQueue {
    static final SynchronousQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
        boolean flag = queue.offer("插入");
        System.out.println(flag);
        System.out.println("完成");
    }
}
