package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程池预启动线程等方法
 * <p>2020/8/4 15:15</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestPreStart {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 1000, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10));
    public static void main(String[] args) {
        TestPreStart testPreStart = new TestPreStart();
        testPreStart.executor.submit(() -> System.out.println("提交任务"));
        System.out.println(testPreStart.executor.getPoolSize());
        // KLH: 2020/8/4 预先启动一个核心线程
        testPreStart.executor.prestartCoreThread();
        System.out.println(testPreStart.executor.getPoolSize());
        // KLH: 2020/8/4 预先启动所有核心线程，
        int i = testPreStart.executor.prestartAllCoreThreads();
        System.out.println(i);
        int i1 = testPreStart.executor.prestartAllCoreThreads();
        System.out.println(i1);
        // KLH: 2020/8/4 获取线程池中目前正在执行任务的活跃线程,并不是线程池中存在的线程数量
        System.out.println(testPreStart.executor.getActiveCount());
        // KLH: 2020/8/4 获取当前线程池大小
        System.out.println(testPreStart.executor.getPoolSize());
    }
}
