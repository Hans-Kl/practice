package lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 测试为什么lambda里面的变量必须是final
 * <p>2020/12/12 18:12</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
    }

    public static void t1(List list) {
        LinkedList<Object> objects = new LinkedList<>();
        int a = 0;
        list.forEach(l -> {
                    System.out.println(a);
                }
        );
    }

    public static void t2() {
        Consumer c = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        System.out.println(c);
    }

    public static void t3() {
        Consumer c = o -> System.out.println(o);
        System.out.println(c);
    }

    public static void t4() {
        Consumer c = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        System.out.println(c);
    }

    public static void t5() {
        int a = 0;

    }
}
