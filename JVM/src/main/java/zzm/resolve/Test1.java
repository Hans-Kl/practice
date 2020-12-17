package zzm.resolve;

/**
 * 测试解析中的静态分派
 * <p>2020/12/12 22:19</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test1 {

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        Woman woman1 = new Woman();
        Test1 sr = new Test1();
        sr.sayHello(man);
        sr.sayHello(woman);
        sr.sayHello(woman1);
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public int  sayHello(Man guy) {
        System.out.println("hello,gentleman!");
        return 1;
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }
}
