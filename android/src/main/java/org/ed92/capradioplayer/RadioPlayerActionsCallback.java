package org.ed92.capradioplayer;


import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;

public class RadioPlayerActionsCallback {

    private MediaSessionCompat mMediaSessionCompat;

    private RadioPlayerService mRadioService;

    public RadioPlayerActionsCallback(MediaSessionCompat mediaSessionCompat, RadioPlayerService radioService) {
        mMediaSessionCompat = mediaSessionCompat;
        mRadioService = radioService;
    }

    /**
     * What happens when users want to play radio
     */
    public static void onPlay(Context context) {
        /*
         TODO
          * Send signal to RUN ionic player
          * Update android notification
         */
        RadioPlayerNotification.setNotifPlay();
    }

    /**
     * What happens when user wants to pause radio
     */
    public static void onPause(Context context) {
        /*
         TODO
          * Send signal to PAUSE ionic player
          * Update android notification
         */
        RadioPlayerNotification.setNotifPause(context);
    }
}