package com.hans.springboot.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <p>2021/3/1 16:15</p>
 *
 * @author konglinghan
 * @version 1.0
 */
@Service
@Lazy
public class LazyService implements InitializingBean {
    public LazyService() {
        System.out.println("LazyService Constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("lazy set props");
    }
}
