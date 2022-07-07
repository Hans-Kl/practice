package innerClass;

/**
 * <p>2021/1/19 12:30</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
//        Outer outer = new Outer();
        Outer.Inner inner = new Outer.Inner();
        System.out.println("a".codePointAt(0));
    }
}
