package singleton;

/**
 * 多线程环境下利用<cinit>方法只会被jvm执行一次的特性(jvm保证),
 * 控制创建的实例在jvm中只有一个,也称为饿汉式.
 * java.lang.Runtime#getRuntime()是jdk对此单例模式的实现
 * 缺点:
 * 1. 即使不需要也会被创建
 * 2. 无法传入参数
 * <p>2020/12/3 14:54</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class StaticSingleton {
    private static StaticSingleton instance = new StaticSingleton();

    private StaticSingleton() {
    }

    public static StaticSingleton getInstance() {
        return instance;
    }
}
