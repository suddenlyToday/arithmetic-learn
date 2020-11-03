package com.lyt.learn;

import java.util.Random;

public class ReservoirSampling {
    public int[] sample(int[] tStream, int resNum) {
        int[] res = new int[resNum];
        // copy item from stream to res when index < resNum
        if (resNum >= 0) System.arraycopy(tStream, 0, res, 0, resNum);

        // when index < resNum
        // get a random int ri range [0, index]
        // if ri in (0, resNum)
        // reset res[ri] = stream[index]
        Random random = new Random();
        for (int i = resNum; i < tStream.length; i++) {
            int temp = random.nextInt(i + 1);// +1 because bound is exclusive
            if (temp < resNum) {
                res[temp] = tStream[i];
            }
        }
        return res;
    }
}
