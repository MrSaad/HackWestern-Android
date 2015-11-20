package com.mrsaad.hackwestern;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    TextView timerTextView;
    HackathonConstants constants;
    Handler h;
    int updateDelay = 1000;

    public HomeFragment() {
        constants = new HackathonConstants();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //set view elements
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        timerTextView = (TextView)root.findViewById(R.id.timer_text);

        //set initial text
        timerTextView.setText(constants.countdownText());
        timerTextView.setTextColor(constants.countdownTextColor());

        //set updater
        h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                timerTextView.setText(constants.countdownText());
                timerTextView.setTextColor(constants.countdownTextColor());
                h.postDelayed(this, updateDelay);
            }
        }, updateDelay);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
