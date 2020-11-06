package syncutil.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>2020/11/2 09:29</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestCyclicBarrier {
    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()-> System.out.println("action"));
    public static final Runnable r = () -> {
        System.out.println("去爬山");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("山脚出发");
    };

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < 9; i++) {
            new Thread(r).start();
        }
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println("还差一个人");
        cyclicBarrier.await();
        System.out.println("到位");
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
    }
}
