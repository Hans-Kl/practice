package threadpool.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>2020/9/20 17:19</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TaskExecutor {

    private final BlockingQueue<Runnable> channel;

    public TaskExecutor() throws InterruptedException {
        channel = new ArrayBlockingQueue<>(10);
        process();
    }

    public void accept(Runnable runnable) throws InterruptedException {
        channel.put(runnable);
    }

    public void process() throws InterruptedException {
        new Thread(()-> {
            while (true) {
                System.out.println("processing");
                Runnable task = null;
                try {
                    task = channel.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(task);
            }
        }).start();
    }

}
