package blockqueue.my;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>2020/11/5 17:06</p>
 * 实现阻塞队列
 * @author konglinghan
 * @version 1.0
 */
public class MyBQ {
    public static final List<Integer> QUEUE = new LinkedList<Integer>();
    public static final int size = 10;

    public synchronized void put(Integer integer) throws InterruptedException {
        while (QUEUE.size() == 10) {
            wait();
        }
        if (QUEUE.size() == 0) {
            notifyAll();
        }
        QUEUE.add(integer);
    }


    public synchronized Integer take() throws InterruptedException {
        while (QUEUE.size() == 0) {
            wait();
        }
        if (QUEUE.size() == 10) {
            notifyAll();
        }
        return QUEUE.remove(0);
    }
    public static final MyBQ myBQ = new MyBQ();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                System.out.println(myBQ.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(()->{
            try {
                myBQ.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
