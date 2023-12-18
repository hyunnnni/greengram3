package com.green.greengram3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exam1 {

    @Test
    @DisplayName("테스트1")
    public void test1(){
        System.out.println("test1");
        int sum = 2+2;
        Assertions.assertEquals(5, sum); // 왼쪽이 내가 기대하는 값, 오른쪽이 실제 값
        //비교하는 메소드

    }

    @Test
    public void test2(){
        System.out.println("test2");
        int multi = 2*3;
        Assertions.assertEquals(6, multi);
    }

    @Test
    public void test3(){
        Assertions.assertEquals(4, MyUtils.sum(2,2));
        Assertions.assertEquals(5, MyUtils.sum(2,3));
        Assertions.assertEquals(17, MyUtils.sum(8,9));
    }

    @Test
    public void test4(){
        MyUtils mu = new MyUtils();
        Assertions.assertEquals(4,mu.multi(2,2));
        Assertions.assertEquals(10,mu.multi(5,2));
        Assertions.assertEquals(32,mu.multi(4,8));
    }
}
