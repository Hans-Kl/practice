package singleton;

/**
 * 单线程环境下单例模式,线程不安全
 * <p>2020/12/3 14:52</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class SingleThreadSingleton {
    private static SingleThreadSingleton instance;
    private String field;

    private SingleThreadSingleton(String arg) {
    }

    public static SingleThreadSingleton getInstance(String arg) {
        if (instance == null) {
            instance = new SingleThreadSingleton(arg);
        }
        return instance;
    }
}
