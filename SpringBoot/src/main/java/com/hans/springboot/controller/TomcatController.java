package com.hans.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Tomcat性能
 * <p>2021/1/10 18:22</p>
 *
 * @author konglinghan
 * @version 1.0
 */
@RestController
public class TomcatController {
    @RequestMapping("defaultConfig")
    public String defaultConfig(String p) throws InterruptedException {
        System.out.println(p);
        Thread.sleep(20000);
        return "ret" + p;
    }
}
