package zzm;

/**
 * 测试String,字符串常量池等概念
 * <p>2020/11/26 17:47</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestString {
    public static void main(String[] args) {
//        mt1();
//        klh2();
//        klh3();
//        klh4();
//        klh5();
        klh6();
    }

    public static void mt1() {
        String s = new String("1");
        String sn = new String("1");

        System.out.println(s==sn);

        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String intern = s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(intern == s4);
    }


    public static void klh1() {
        //在字符串常量池中创建 "konglinghan"这个对象,并指向klh引用
        String klh = "konglinghan";

        //可以看到这里IDE提示.intern()可以省略,
        // 侧面说明 "字符串值" 这种形式直接将 字符串 加入了字符串常量池中
        String klh1 = "konglinghan".intern();

    }

    //true
    public static void klh2() {
        String klh1 = new String("konglinghan");
        String klh = "konglinghan";
        System.out.println(klh==klh1.intern());
    }

    //true
    public static void klh4() {
        String klh1 = "kongling" + "han";
        String klh = "konglinghan";
        System.out.println(klh==klh1);
    }

    //false
    public static void klh3() {
        String klh1 = new String("kongling") + new String("han");
        String klh = "konglinghan";
        System.out.println(klh==klh1);
    }

    //false**
    public static void klh5() {
        String klh = "konglinghan";//指向字符串常量池中对象
        String klh1 = new String("kongling") + new String("han");//指向heap中对象
        System.out.println(klh1==klh1.intern());//klh1.intern()的返回值
    }

    //true**
    public static void klh6() {
        String klh1 = new String("kongling") + new String("han");
        System.out.println(klh1==klh1.intern());
    }


}
