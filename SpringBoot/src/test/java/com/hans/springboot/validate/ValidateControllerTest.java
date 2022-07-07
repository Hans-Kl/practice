package com.hans.springboot.validate;

import com.hans.springboot.SpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author klhans
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidateControllerTest {
    @Autowired
    ValidateController validateController;

    @Test
    public void drink() {
        Foo foo = new Foo();
        foo.setAge(1);
        String live = validateController.live(foo);
        System.out.println(live);
    }
}