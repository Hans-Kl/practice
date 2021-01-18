package string;

/**
 * 字符串拼接测试
 * <p>2021/1/18 17:13</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class StringConcat {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        testStringPlus("klh", "abcd", 100000);//1000:20  100000:18319 原因:大量sb对象
//        testStringConcat("klh", "abcd", 100000);//1000:5 100000:5693 原因:大量String对象
        testStringBuilder("klh", "abcd", 100000);//1000:1 100000:57 原因:一个sb对象和一个String对象
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void testStringPlus(String str, String apd, int count) {
        for (int i = 0; i < count; i++) {
            str += apd;
        }
        System.out.println(str);
    }

    private static void testStringConcat(String str, String apd, int count) {
        String ret = str;
        for (int i = 0; i < count; i++) {
            ret = ret.concat(apd);
        }
        System.out.println(ret);
    }

    private static void testStringBuilder(String str, String apd, int count) {
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < count; i++) {
            stringBuilder.append(apd);
        }
        System.out.println(stringBuilder.toString());
    }
}
