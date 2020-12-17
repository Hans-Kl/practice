package stream;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * <p>2020/12/11 14:08</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        t1();
    }

    private static void t1() {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        LinkedList<Apple> apples = new LinkedList<>();
        apples.add(apple2);
        apples.add(apple1);

        // KLH: 对流进行peek操作会影响到数据源
        apples.stream().peek(System.out::println).peek(a -> a.setColor("苹果")).peek(a -> System.out.println(
                "asdf" + a.getColor())).limit(1).collect(Collectors.toList());

        System.out.println(apples.get(0).getColor());
    }

}
