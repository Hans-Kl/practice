package stream;

import java.util.LinkedList;
import java.util.List;

/**
 * 测试不使用stream的情况下如何进行集合计算
 * <p>2020/12/11 16:20</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setPrice(0.5);
        Apple apple2 = new Apple();
        apple2.setColor("red");
        apple2.setPrice(1.0);
        Apple apple3 = new Apple();
        apple3.setColor("white");
        apple3.setPrice(0.5);
        LinkedList<Apple> apples = new LinkedList<>();
        apples.add(apple2);
        apples.add(apple1);
        apples.add(apple3);

        tStream(apples);
    }

    /**
     * 计算红苹果的总价格
     * @param apples
     */
    private static void tStream(List<Apple> apples) {
        double red = apples.stream()
                .filter(apple -> apple.getColor().equals("red"))
                .mapToDouble(Apple::getPrice)
                .sum();
        System.out.println(red);
    }

    private static void t1(List<Apple> apples) {
        for (Apple apple : apples) {

        }
    }
}
