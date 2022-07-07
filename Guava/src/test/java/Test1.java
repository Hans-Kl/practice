import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * <p>2021/3/8 10:36</p>
 *
 * @author klhans
 * @version 1.0
 */
public class Test1 {
    private static final Splitter URI_SPLITTER = Splitter.on('/').trimResults().omitEmptyStrings();

    @Test
    public void test1() {
        Preconditions.checkArgument(1 < 0, "age 必须大于0");
    }

    @Test
    public void test2() {
        List<String> strings = URI_SPLITTER.splitToList("usertask/get/");
        System.out.println(strings);
    }

    @Test
    public void test3() {
        StringBuilder stringBuilder = Joiner.on('/').appendTo(new StringBuilder("a"), Arrays.asList("b", "c"));
        System.out.println(stringBuilder);
    }
}
