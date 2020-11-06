package threadlocal;

/**
 * <p>2020/9/28 18:31</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Student {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("正在回收student");
    }
}
