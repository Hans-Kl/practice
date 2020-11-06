package syncutil.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <p>2020/11/2 13:31</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestSemaphore {
    public static final Semaphore SEMAPHORE = new Semaphore(2);
    public static void main(String[] args) throws InterruptedException {
        SEMAPHORE.acquire(2);
        SEMAPHORE.release(2);
    }
}
