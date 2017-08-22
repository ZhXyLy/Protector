package ai.hou.protector;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by hou on 2017/8/22
 */

public class ClockService extends Service {
    public static final String CLOCK_ACTION = "ai.hou.protector.CLOCK_TIMER";
    public static final String FLAG = "period";
    public static final int PERIOD = 1000 * 60 * 10;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int period = intent.getIntExtra(FLAG, PERIOD);
        countTimer(period);
        return START_STICKY;
    }

    private void countTimer(final int period) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ClockService.CLOCK_ACTION);
                while (true) {
                    try {
                        Thread.sleep(period);
                        sendBroadcast(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}
