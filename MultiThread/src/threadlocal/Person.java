package threadlocal;

import java.lang.ref.WeakReference;

/**
 * <p>2020/9/28 18:31</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Person extends WeakReference<Student> {
     String name = "人类";

    public Person(Student referent) {
        super(referent);
    }
}
