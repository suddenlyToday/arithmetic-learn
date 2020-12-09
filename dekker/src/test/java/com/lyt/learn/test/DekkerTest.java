package com.lyt.learn.test;

import com.lyt.learn.Dekker;
import com.lyt.learn.ErrorDekker;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class DekkerTest {

    // no critical section, res will < 200000
    @Test
    public void testProcessWithOutCriticalZone() throws InterruptedException {
        int length = 100000;
        Counter res = new Counter();
        CountDownLatch cdl = new CountDownLatch(2);
        new Thread(() -> {
            for (int i = 0; i < length; i++) {
                res.setCount(res.count + 1);
            }
            cdl.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < length; i++) {
                res.setCount(res.count + 1);
            }
            cdl.countDown();
        }).start();

        cdl.await();

        System.out.println(res.count);
        Assert.assertTrue(res.count < length * 2);
    }

    // in critical section, res will == 200000
    @Test
    public void testProcessInCriticalZone() throws InterruptedException {
        Counter res = new Counter();
        Dekker dekker = new Dekker(() -> res.setCount(res.count + 1));

        int length = 1000000;
        CountDownLatch cdl = new CountDownLatch(2);
        new Thread(() -> {
            for (int i = 0; i < length; i++) {
                dekker.process1();
            }
            cdl.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < length; i++) {
                dekker.process2();
            }
            cdl.countDown();
        }).start();

        cdl.await();

        System.out.println(res.count);
        Assert.assertEquals(res.count, length * 2);
    }

    @Test
    @Ignore("错误实现的dekker，本应成功，但它失败了，原因是volatile关键字的使用")
    public void testProcessInWrongCriticalZone() throws InterruptedException {
        Counter res = new Counter();
        ErrorDekker dekker = new ErrorDekker(() -> res.setCount(res.count + 1));

        int length = 1000000;
        CountDownLatch cdl = new CountDownLatch(2);
        new Thread(() -> {
            for (int i = 0; i < length; i++) {
                dekker.process(1);
            }
            cdl.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < length; i++) {
                dekker.process(0);
            }
            cdl.countDown();
        }).start();

        cdl.await();

        System.out.println(res.count);
        Assert.assertEquals(res.count, length * 2);
    }

    static class Counter {
        public volatile int count = 0;

        public void setCount(int count) {
            this.count = count;
        }
    }
}