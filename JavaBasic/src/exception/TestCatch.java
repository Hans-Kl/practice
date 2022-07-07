package exception;

/**
 * <p>2021/1/29 10:41</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestCatch {
    public static void main(String[] args) {
//        t1();
        t2();
    }

    private static void t1() {
        int i = 1;
        if (i == 1) {
            throw new RuntimeException("cccccc");
        }
        System.out.println("end");
    }

    private static void t2() {
        int i = 1;
        try {
            if (i == 1) {
                throw new RuntimeException("cccccc");
            }
        }catch (Exception e ){

        }
        System.out.println("end");
    }
}
