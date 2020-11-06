package threadpool.pc;

/**
 * <p>2020/9/20 17:33</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        TaskExecutor taskExecutor = new TaskExecutor();
        System.out.println(Thread.currentThread().getName());
            taskExecutor.accept(()-> System.out.println(Thread.currentThread().getName()));
    }
}
