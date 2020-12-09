package com.lyt.learn;

public class Dekker {
    private volatile boolean p1Want = false;
    private volatile boolean p2Want = false;
    private volatile int turn = 1; // 1 ,2
    private Runnable criticalSectionCode;

    public Dekker(Runnable criticalSectionCode) {
        this.criticalSectionCode = criticalSectionCode;
    }

    public void process1(){
        p1Want = true; // 举手
        while (p2Want){ // 如果其他人也举手，等待其他人手放下来
            if (turn == 2) { // 如果现在轮到别人
                p1Want = false; // 自己放下手
                while (turn == 2) ; // 等待，直到轮到自己
                p1Want = true; // 等待成功，举手
            }
        }

        criticalSectionCode.run(); //临界区
        turn = 2; // 将turn轮转给别人
        p1Want = false; // 放手
    }

    public void process2() {
        p2Want = true;
        while (p1Want) {
            if (turn == 1) {
                p2Want = false;
                while (turn == 1);
                p2Want= true;
            }
        }

        criticalSectionCode.run();
        turn = 1;
        p2Want = false;
    }
}
