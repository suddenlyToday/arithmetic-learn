package com.lyt.learn.test;

import com.lyt.learn.ReservoirSampling;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class ReservoirSamplingTest {

    /**
     * 1000个大小的数组（0-999），每次取50个，取20000次
     * 最后一共得到100，0000个数
     * 得到的结果0-999的个数应该都在1000个左右
     */
    @Test
    public void sample() {
        int streamNum = 1000;
        int sampleNum = 50;
        int testTimes = 20000;
        ReservoirSampling sampling = new ReservoirSampling();
        int[] testArr = generateTestArr(streamNum);

        int[] everyNumCount = new int[streamNum];
        Arrays.fill(everyNumCount, 0);
        for (int i = 0; i < testTimes; i++) {
            int[] sampleArr = sampling.sample(testArr, sampleNum);

            // count every sample num's count
            for (int sa : sampleArr) {
                everyNumCount[sa]++;
            }
        }

        // every sample num count must nearly 1000
        for (int i = 0; i < streamNum; i++) {
            Assert.assertTrue(String.format("%s,count:%s", i, everyNumCount[i]),Math.abs(everyNumCount[i] - streamNum) < streamNum * 0.15);
        }
    }

    private int[] generateTestArr(int num) {
        if (num <= 0) {
            return new int[0];
        }

        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i;
        }
        return res;
    }
}