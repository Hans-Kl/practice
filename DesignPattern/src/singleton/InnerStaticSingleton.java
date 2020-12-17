package singleton;

/**
 * 使用静态内部类延迟初始化的单例模式,克服了StaticSingleton的无法延迟加载的缺点,但无法传参
 * <p>2020/12/3 16:40</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class InnerStaticSingleton {
    private InnerStaticSingleton instance;
    private String field;

    private InnerStaticSingleton(String arg) {
    }

    private static class InnerClass {
        private static InnerStaticSingleton innerInstance = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance(String arg){
        if (instance == null) {
            instance=InnerClass.innerInstance;
        }
    }
}
