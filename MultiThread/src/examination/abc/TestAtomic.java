package examination.abc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>2020/10/16 13:53</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestAtomic {
    private static AtomicInteger COUNT = new AtomicInteger();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 10; ) {
                if ((COUNT.get() % 3 == 0)) {
                    System.out.println(i + "a");
                    COUNT.getAndIncrement();
                    i++;
                }
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; ) {
                if ((COUNT.get() % 3 == 1)) {
                    System.out.println("b");
                    COUNT.getAndIncrement();
                    i++;
                }
            }
        });

        Thread c = new Thread(() -> {
            for (int i = 0; i < 10; ) {
                if ((COUNT.get() % 3 == 2)) {
                    System.out.println("c");
                    COUNT.getAndIncrement();
                    i++;
                }
            }
        });

        c.start();
        b.start();
        a.start();

    }
}
