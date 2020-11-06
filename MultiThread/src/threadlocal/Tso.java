package threadlocal;

/**
 * <p>2020/9/29 20:19</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Tso {
    public ThreadLocal<Student> t = ThreadLocal.withInitial(Student::new);

}
