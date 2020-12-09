package com.lyt.learn;

public class ErrorDekker {
    private volatile boolean[] flags = new boolean[2];
    private volatile int turn = 0;

    private Runnable criticalSectionCode;

    public ErrorDekker(Runnable criticalSectionCode) {
        this.criticalSectionCode = criticalSectionCode;
    }

    public void process(int me) {
        int other = 1 - me;

        flags[me] = true; // 举手
        while (flags[other]) { // 如果其他人也举手，等待其他人手放下来
            if (turn == other) { // 如果现在轮到别人
                flags[me] = false; // 自己放下手
                while (turn == other) ; // 等待，直到轮到自己
                flags[me] = true; // 等待成功，举手
            }
        }

        criticalSectionCode.run(); //临界区

        turn = other; // 将turn轮转给别人
        flags[me] = false; // 放手
    }
}
