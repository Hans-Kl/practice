package com.hans.springboot.service;

import lombok.SneakyThrows;

import java.io.IOException;

/**
 * <p>2021/3/5 21:17</p>
 *
 * @author klhans
 * @version 1.0
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        test();
    }

    private static void test() throws IOException {
        throw new RuntimeException(new IOException());
    }
}
