package com.green.greengram3;

import org.junit.jupiter.api.*;

public class Exam2 {


    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }
    @AfterEach
    private void afterEach(){
        System.out.println("afterEach");
    }
}
