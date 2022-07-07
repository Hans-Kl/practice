package finalp;

/**
 * <p>2021/3/7 19:09</p>
 *
 * @author klhans
 * @version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        Cat cat = new Cat();
        cat.color = "white";
        System.out.println(cat);
        System.out.println(cat.color);
        Cat cat1 = t2(cat);
        System.out.println(cat);
        System.out.println(cat.color);
    }

    public static Cat t2(Cat cat) {
        cat.color = "blue";
        Cat cat2 = new Cat();
        cat2.color = "orange";
        cat = cat2;
        cat.color = "black";
        return cat;
    }

    private static class Cat {
        String color;
    }
}
