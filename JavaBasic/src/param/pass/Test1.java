package param.pass;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * <p>2021/2/3 19:51</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
//        t1(1);
        LinkedList<String> objects = new LinkedList<>();
        objects.add("1");
//        objects.stream().peek(System.out::println).collect(Collectors.toList());
        objects.stream().filter(s->s.equals("2")).peek(o-> System.out.println("o"+o)).collect(Collectors.toList());
    }

    public static void t1(int i1) {
        t2(i1);
        System.out.println("t1" + i1);
    }

    public static void t2(final int i2) {
//        i2 = 2;
//        System.out.println("t2" + i2);
    }


}
