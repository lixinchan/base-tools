package com.java.core.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chenlixin at 2015年8月18日 上午10:46:16
 */
public class TraditionalTimer {

    private static int count = 0;

    public static void main(String[] args) {
        // new Timer().schedule(new TimerTask() {
        //
        // @Override
        // public void run() {
        // System.out.println("Ding~Ding~");
        // }
        // }, 1000, 3000);

        class MyTimerTask extends TimerTask {

            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println(count + "Ding~Ding~");
                new Timer().schedule(new MyTimerTask(), 2000 + count * 2000);
            }

        }

        new Timer().schedule(new MyTimerTask(), 2000);

        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
