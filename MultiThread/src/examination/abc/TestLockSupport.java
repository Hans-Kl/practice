package examination.abc;

import java.util.concurrent.locks.LockSupport;

/**
 * <p>2020/10/15 19:10</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestLockSupport {
    static Thread a;
    static Thread b;
    static Thread c;

    public static void main(String[] args) {
        a = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("a");
                LockSupport.unpark(b);
                LockSupport.park();
            }
        });
        b = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.println("b");
                LockSupport.unpark(c);
            }
        });
        c = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.println("c");
                LockSupport.unpark(a);
            }
        });

        a.start();
        b.start();
        c.start();
    }
}
