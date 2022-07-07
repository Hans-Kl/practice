package com.hans.springboot.controller;

import com.hans.springboot.service.LazyService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>2021/3/1 16:14</p>
 *
 * @author konglinghan
 * @version 1.0
 */
@RestController("demo")
public class DemoController implements InitializingBean {
    @Autowired
//    @Lazy
    LazyService lazyService;

    @GetMapping
    public String get() {
        String s = this.toString();
        System.out.println(s);
        System.out.println(this.lazyService);
        return s;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("demo set prop,lazyService"+lazyService);
        System.out.println("demo set prop");

    }
}
