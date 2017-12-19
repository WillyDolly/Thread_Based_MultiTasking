package com.popland.pop.thread_based_multitasking;

import android.util.Log;

/**
 * Created by hai on 19/12/2017.
 */

public class TickTock {
    String status;

    synchronized void tick(boolean running){
        if(!running){
            status = "ticked";
            notify();//wake up waiting tock Thread or it will wait for good
            return;
        }

        Log.i("TT","tick");
        status = "ticked";
        notify();

        try {
            while(!status.equals("tocked"))//avoid unusual wake-up
                wait();
        } catch (InterruptedException e) {
            Log.i("TT","thread interrupted");
        }
    }

    synchronized void tock(boolean running){
        if(!running){
            status = "tocked";
            notify();
            return;
        }

        Log.i("TT","tock");
        status = "tocked";
        notify();

        try{
            while(!status.equals("ticked"))
                wait();
        }catch(InterruptedException ex){
            Log.i("TT","thread interrupted");
        }
    }
}
