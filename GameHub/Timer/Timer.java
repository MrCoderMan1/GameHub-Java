package Timer;

import java.text.SimpleDateFormat;
import java.util.*;

public class Timer implements Runnable {
    public String myDate;
    public Thread t;

    public Timer(String threadName) {
        t = new Thread(this, threadName);
    }

    public void run() {
        while (true) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            myDate = formatter.format(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
