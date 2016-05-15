package com.example.geoquizlab1solution;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Student on 3/2/2016.
 */
public class AudioPlayer extends java.lang.Object{

    private MediaPlayer mPlayer;


    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }


    public void play(Context c) {
//   Calling stop()  prevents the creation of multiple instances of MediaPlayer if the user clicks the Play button twice.
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.java_course);
//        mPlayer = MediaPlayer.create(c, R.raw.apollo_17_stroll);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
//           stop() ; releases your hold on the MediaPlayer instance as soon as you no longer need it.
                stop();
            }
        });

        mPlayer.start();

    }
}
