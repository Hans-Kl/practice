package innerClass;

/**
 * <p>2021/1/19 12:31</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Outer {
    static {
        System.out.println("outer load");
    }

    private Inner inner;

    public static class Inner {
        static {
            System.out.println("inner load");
        }
    }
}
