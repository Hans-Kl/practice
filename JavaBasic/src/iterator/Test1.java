package iterator;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>2020/12/11 07:27</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test1 {

    public static void main(String[] args) {

    }

    private static void t1(List list) {
        // KLH: foreach是语法糖,反编译之后底层是迭代器
        //  常用的Iterator接口其实就是迭代器模式的一种体现,我们经常使用,却忽视了他也是一种标准的设计模式
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private static void t2(List list) {

    }

}
