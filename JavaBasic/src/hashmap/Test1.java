package hashmap;

import java.util.HashMap;

/**
 * <p>2020/12/1 11:57</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(3);
        map.put("123", "safd");
        System.out.println(map);
    }
}
