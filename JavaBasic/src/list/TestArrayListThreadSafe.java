package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 测试ArrayList是否线程安全
 * <p>2020/12/29 16:13</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestArrayListThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);

        Iterator<Integer> iterator = integers.iterator();
        LinkedList<Object> objects = new LinkedList<>();
        Iterator<Object> iterator1 = objects.iterator();

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Integer integer = integers.get(0);
                try {
                    Thread.sleep(3);// TODO: 2020/12/29 模拟线程中断,出现线程安全问题
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(integer);
                integers.set(0, ++integer);
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(integers.get(0));
    }
}
