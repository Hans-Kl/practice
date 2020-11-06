package threadpool.pc;

import java.util.concurrent.*;

/**
 * <p>2020/9/25 11:09</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestAsyncRemote {
    static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        caseExecutorService();
//        caseCompletionService();
        System.out.println((System.currentTimeMillis()-start));
    }

    private static void caseExecutorService() throws ExecutionException, InterruptedException, TimeoutException {
        Future<String> submitM = executor.submit(TestAsyncRemote::remoteM);
        Future<String> submitA = executor.submit(TestAsyncRemote::remoteA);
        Future<String> submitT = executor.submit(TestAsyncRemote::remoteT);
        System.out.println(submitM.get());
        System.out.println(submitA.get());
        System.out.println(submitT.get());
//        executor.shutdownNow();
    }

    private static void caseCompletionService() throws InterruptedException, ExecutionException {
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        completionService.submit(TestAsyncRemote::remoteM);
        completionService.submit(TestAsyncRemote::remoteT);
        completionService.submit(TestAsyncRemote::remoteA);

        for (int i = 0; i < 2; i++) {
            Future<String> take = completionService.take();
            System.out.println(take.get());
            Future<String> take1 = completionService.take();
            System.out.println(take1.get());
            Future<String> take2 = completionService.take();
            System.out.println(take2.get());
        }
        executor.shutdownNow();
    }

    private static String remoteA() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "remote ali 0.5s";
    }

    private static String remoteT() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "remote Tencent 1s";
    }

    private static String remoteM() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "remote Meituan 3s";
    }

}
