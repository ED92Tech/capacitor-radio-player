package org.ed92.capradioplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * A class to handle control actions sent by user,
 * such as Play or Pause. These actions can be sent
 * via notifications ("Play/Pause" button), or via
 * the radio player (in the app itself) for instance.
 */
public class RadioPlayerUserActionsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            switch (action) {
                case RadioPlayerService.ACTION_PLAY:
                    RadioPlayerActionsCallback.onPlay(context);
                    break;

                case RadioPlayerService.ACTION_PAUSE:
                    RadioPlayerActionsCallback.onPause(context);
                    break;
            }
        }

    }
}
