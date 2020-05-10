package org.ed92.capradioplayer;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static org.ed92.capradioplayer.RadioPlayerService.ACTION_PAUSE;
import static org.ed92.capradioplayer.RadioPlayerService.ACTION_PLAY;
import static org.ed92.capradioplayer.RadioPlayerService.PLAYER_NOTIFICATION_ID;

public class RadioPlayerNotification {

    private static NotificationCompat.Builder mNotifBuilder;

    private static NotificationCompat.Action mPauseAction;
    private static NotificationCompat.Action mPlayAction;


    public static NotificationCompat.Builder getNotificationBuilder(Context context) {
        if (mNotifBuilder == null) {
            initNotificationActions(context);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, null); // TODO put right channelId
            builder.setContentTitle("TODO: content title");
            builder.setContentText("TODO: content text");
            builder.addAction(mPlayAction); // TODO check state to set action
            builder.setAutoCancel(false);

            mNotifBuilder = builder;
        }
        return mNotifBuilder;
    }

    private static void initNotificationActions(Context context) {
        // Pause intent
        Intent pauseIntent = new Intent(context, RadioPlayerService.class);
        pauseIntent.setAction(ACTION_PAUSE);
        PendingIntent pausePendingIntent = PendingIntent.getService(context, 0, pauseIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mPauseAction = new NotificationCompat.Action(android.R.drawable.ic_media_play, "Pause", pausePendingIntent);

        // Play intent
        Intent playIntent = new Intent(context, RadioPlayerService.class);
        playIntent.setAction(ACTION_PLAY);
        PendingIntent playPendingIntent = PendingIntent.getService(context, 0, playIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mPlayAction = new NotificationCompat.Action(android.R.drawable.ic_media_play, "Play", playPendingIntent);
    }

    private static void reNotify(Context context) {
        NotificationManagerCompat.from(context).notify(PLAYER_NOTIFICATION_ID, mNotifBuilder.build());
    }

    @SuppressLint("RestrictedApi")
    public static void setNotifPause(Context context) {
        mNotifBuilder.mActions.clear();
        mNotifBuilder.addAction(mPauseAction);
        reNotify(context);
    }

    @SuppressLint("RestrictedApi")
    public static void setNotifPlay() {
        mNotifBuilder.mActions.clear();
        mNotifBuilder.addAction(mPlayAction);
    }
}
