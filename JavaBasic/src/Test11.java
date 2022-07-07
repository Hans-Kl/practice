import string.StringConcat;
import sun.misc.Launcher;

/**
 * @author klhans
 */
public class Test11 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("asdfafs");
        StringConcat linkedLRU = new StringConcat();
        System.out.println(linkedLRU.getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader());
//        ClassLoader.getSystemClassLoader().loadClass(DpRelationConsumer.class.getName()).get
        System.out.println(new Launcher().getClassLoader().getParent().getParent());
//        System.out.println(System.getProperty("java.class.path"));
//        System.out.println("---------------------------------");
//        System.out.println(System.getProperty("java.ext.dirs"));
//        System.out.println("---------------------------------");
//
//        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
