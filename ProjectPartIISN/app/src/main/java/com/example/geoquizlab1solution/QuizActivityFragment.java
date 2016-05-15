package com.example.geoquizlab1solution;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Student on 3/2/2016.
 */
public class QuizActivityFragment extends Fragment {

    private Button mPlayButton;
    private Button mStopButton;
    private AudioPlayer mPlayer = new AudioPlayer();


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        setRetainInstance(true);
    }

    @TargetApi(11)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz_activity, parent, false);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {


            if (NavUtils.getParentActivityName(getActivity()) != null) {

                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

            mPlayButton = (Button) v.findViewById(R.id.quiz_playButton);

            mPlayButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mPlayer.play(getActivity());
                }
            });

            mStopButton = (Button) v.findViewById(R.id.quiz_stopButton);

            mStopButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    mPlayer.stop();

                }
            });

            return v;

        }


        @Override
        public void onDestroy () {
            super.onDestroy();
            mPlayer.stop();

        }
    }

