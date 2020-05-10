package org.ed92.capradioplayer;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class RadioPlayerService extends Service {

    private NotificationCompat.Builder mPlayerNotificationBuilder;

    public static final int PLAYER_NOTIFICATION_ID = 1;

    public static final String ACTION_PAUSE = "pause";
    public static final String ACTION_PLAY = "play";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initPersistentNotification();

    }

    private void initPersistentNotification() {
        mPlayerNotificationBuilder = RadioPlayerNotification.getNotificationBuilder(this);
        IntentFilter userEventsAccepted = new IntentFilter();
        userEventsAccepted.addAction(ACTION_PLAY);
        userEventsAccepted.addAction(ACTION_PAUSE);
        registerReceiver(new RadioPlayerUserActionsReceiver(), userEventsAccepted);
    }

    public void showPersistentNotification() {
        Notification playerNotif = mPlayerNotificationBuilder.build();
        NotificationManagerCompat.from(this).notify(PLAYER_NOTIFICATION_ID, playerNotif);
    }
}
