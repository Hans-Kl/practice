package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>2020/12/3 18:38</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class RegistrySingleton {
    private static Map registry = new HashMap<String, Object>();

    public static RegistrySingleton getInstance(String classname) {
        Object singleton = registry.get(classname);
        if (singleton == null) {
            try {
                singleton = Class.forName(classname).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            registry.put(classname, singleton);
        }
        return (RegistrySingleton) singleton;
    }

    public static void main(String[] args) {
        getInstance("RegistrySingleton").check();
    }

    public void check() {
        System.out.println("the instance has been created");
    }
}
