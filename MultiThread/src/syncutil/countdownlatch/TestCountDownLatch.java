package syncutil.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * <p>2020/10/28 19:37</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestCountDownLatch {
    public static final CountDownLatch countDownLatch = new CountDownLatch(10);
    static final Thread t1 = new Thread(() -> {
        System.out.println("start");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }, "t1");

    static final Thread t3 = new Thread(() -> {
        System.out.println("start");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("都被唤醒饿了");
    }, "t3");

    static final Thread t2 = new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + "start");
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + "end");
    } );

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t3.start();
//        t2.start();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "start");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "end");
            } ).start();
        }
        System.out.println(countDownLatch.getCount());
        countDownLatch.await();
        System.out.println("不再被阻塞");
    }
}
