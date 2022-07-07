package threadlocal;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>2020/9/28 11:36</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestThreadLocal {
    static final ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(() -> "init");

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        case1();
//        case2();
//        case3();
//        case4();
//        caseStudents();
        case6();
//        case7();
    }

    private static void case1() {
        final ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(() -> "dsf");
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        System.out.println(stringThreadLocal.get());
        System.out.println(integerThreadLocal.get());
        integerThreadLocal.set(1);
        System.out.println(integerThreadLocal.get());
    }

    public static void case2() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<?> submit1 = es.submit(() -> {
            stringThreadLocal.set(Thread.currentThread().getName());
            System.out.println(stringThreadLocal.get());
        });
        Future<?> submit2 = es.submit(() -> {
            stringThreadLocal.set(Thread.currentThread().getName());
            System.out.println(stringThreadLocal.get());
        });
        Future<?> submit3 = es.submit(() -> {
            stringThreadLocal.set("3");
            System.out.println(stringThreadLocal.get());
        });
        submit1.get();

    }

    public static void case3() throws InterruptedException {
        String s = "soft";
//        ReferenceQueue<String> stringReferenceQueue = new ReferenceQueue<>();
//        SoftReference<String> stringSoftReference = new SoftReference<>(s, stringReferenceQueue);
//        String s1 = stringReferenceQueue.poll().get();
        SoftReference<String> stringSoftReference = new SoftReference<>("safd");
        System.out.println(stringSoftReference.get());
        System.gc();
        Thread.sleep(5000L);
        System.out.println(stringSoftReference.get());
    }

    public static void case4() throws InterruptedException {
//        Student student = new Student();
//        ReferenceQueue<String> stringReferenceQueue = new ReferenceQueue<>();
//        SoftReference<String> stringSoftReference = new SoftReference<>(s, stringReferenceQueue);
//        String s1 = stringReferenceQueue.poll().get();
        WeakReference<WeakReference> stringWeakReference = new WeakReference<>(new WeakReference<Student>(new Student()));

        System.out.println(stringWeakReference.get());
        System.out.println(stringWeakReference.get().get());
        System.gc();
        Thread.sleep(5000L);
        System.out.println(stringWeakReference.get());
//        System.out.println(stringWeakReference.get().get());
        System.out.println(stringWeakReference);
    }

    public static void caseStudents() throws InterruptedException {
        Person person = new Person(new Student());
        System.out.println(person.get());
        System.gc();
        Thread.sleep(5000);
        System.out.println(person.get());
        System.out.println(person);
    }

    /**
     * 测试threadLocal只有弱引用的时候被gc
     *
     * @throws InterruptedException
     */
    public static void case6() throws InterruptedException {
        Tso tso = new Tso();
        Object o = tso.t.get();
        System.out.println(o);
        tso.t = null;
        // KLH: 2020/9/29 threadLocal对象只有弱引用被gc
        System.gc();
        Thread.sleep(5000);
        Thread thread = Thread.currentThread();
        System.out.println("over");
    }

    /**
     * 测试threadLocal.remove()方法的效果,结果:entry被删除,包括key和value
     *
     * @throws InterruptedException
     */
    public static void case7() throws InterruptedException {
        Tso tso = new Tso();
        Object o = tso.t.get();
        System.out.println(o);
        tso.t.remove();
        System.gc();
        Thread.sleep(5000);
        Thread thread = Thread.currentThread();
        System.out.println("over");
    }


    @Test
    public void test12() {
        t1();
        t2();
    }

    private void t1() {
        ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 520);
        System.out.println(local.get());
    }

    private void t2() {
        System.gc();//提示JVM进行GC

        Thread thread = Thread.currentThread();

        System.out.println(thread);
    }

}
