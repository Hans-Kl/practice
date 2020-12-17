package singleton;

/**
 * 双检锁懒汉式 单例模式
 * <p>2020/12/3 15:00</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class DCLSingleton {
    private static DCLSingleton instance;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            instance = new DCLSingleton();
        }
        return instance;
    }
}
