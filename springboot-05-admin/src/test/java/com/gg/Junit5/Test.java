package com.gg.Junit5;

import org.junit.jupiter.api.*;

@DisplayName("junit5功能测试类")
public class Test {

    @DisplayName("测试displayName注解")
    @org.junit.jupiter.api.Test
    public void test1(){
        System.out.println("-----");
    }

    @Disabled    //该测试禁用掉。
    @DisplayName("测试方法2")
    @org.junit.jupiter.api.Test
    void test2(){
        System.out.println("==========");
    }

    @BeforeEach
    void testBeaforeEach(){
        System.out.println("测试要开始了。。。");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试要结束了。。。");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试要开始了。。。");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试要结束了。。。");
    }



}
