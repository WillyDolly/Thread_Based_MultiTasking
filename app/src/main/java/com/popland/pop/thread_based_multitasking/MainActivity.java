package com.popland.pop.thread_based_multitasking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TickTock tt = new TickTock();
        MyThread thrTick = new MyThread("tick",tt);
        MyThread thrTock = new MyThread("tock",tt);

        try {
            //ensure thread does all its job before finishing
            thrTick.join();
            thrTock.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//how it works: thread.start-> run -> tickTock.tick -> show "tick" , notify() wake up waiting thread , tick Thread wait()
                                 //-> tickTock.tock ...
    }
}
