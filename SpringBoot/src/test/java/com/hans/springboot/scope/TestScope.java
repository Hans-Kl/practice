package com.hans.springboot.scope;

import com.hans.springboot.bean.PrototypeFamliy;
import com.hans.springboot.bean.SingleChild;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author klhans
 */
@SpringBootTest
public class TestScope {
    @Autowired
    SingleChild singleChild;
    @Autowired
    PrototypeFamliy prototypeFamliy;
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test1() {
        System.out.println(singleChild);
        System.out.println(singleChild);
        System.out.println(singleChild.getPrototypeFamliy());
        System.out.println(singleChild.getPrototypeFamliy());
        System.out.println(singleChild.getPrototypeFamliy());
        System.out.println("------");
        System.out.println(applicationContext.getBean("&prototypeFamliy"));
        System.out.println(applicationContext.getBean("prototypeFamliy"));
        System.out.println(applicationContext.getBean("prototypeFamliy"));
        System.out.println("------");
        System.out.println(applicationContext.getBean("&singleChild"));
        System.out.println(applicationContext.getBean("singleChild"));
        System.out.println(singleChild.prototypeFamliy);
        System.out.println(singleChild.prototypeFamliy);
        System.out.println(singleChild.prototypeFamliy);
        System.out.println(prototypeFamliy);
        System.out.println(prototypeFamliy);
        System.out.println(prototypeFamliy);

    }
}
