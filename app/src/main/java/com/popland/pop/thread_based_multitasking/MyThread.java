package com.popland.pop.thread_based_multitasking;

/**
 * Created by hai on 19/12/2017.
 */

public class MyThread extends Thread {//or implement Runnable, create Thread object
TickTock tickTock;

    public MyThread(String name,TickTock tt){
        super(name);
        tickTock = tt;
        start();
    }

    @Override
    public void run() {
        if(getName().equals("tick")){
            for(int i=0;i<5;i++)
                tickTock.tick(true);
            tickTock.tick(false);
        }else{
            for(int j=0;j<5;j++)
                tickTock.tock(true);
            tickTock.tock(false);
        }
    }
}
