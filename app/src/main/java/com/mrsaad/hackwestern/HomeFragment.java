package com.mrsaad.hackwestern;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class HomeFragment extends Fragment {

    TextView timerTextView;
    TextView complimentsTextView;
    HackathonConstants constants;
    JSONObject complimentsJSON;
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
        complimentsTextView = (TextView)root.findViewById(R.id.compliment_text);

        //load compliments json
        try{
            complimentsJSON = new JSONObject(loadJSONFromAsset("compliments.json"));
        }catch(Exception e){e.printStackTrace();}


        //set initial text
        timerTextView.setText(constants.countdownText());
        timerTextView.setTextColor(constants.countdownTextColor());
        try{
            complimentsTextView.setText(complimentsJSON.getString(constants.countdownHour()));
        }catch(Exception e){e.printStackTrace();}


        //set updater
        h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                timerTextView.setText(constants.countdownText());
                timerTextView.setTextColor(constants.countdownTextColor());
                try{
                    complimentsTextView.setText(complimentsJSON.getString(constants.countdownHour()));
                }catch(Exception e){e.printStackTrace();}
                h.postDelayed(this, updateDelay);
            }
        }, updateDelay);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public String loadJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = HackathonConstants.appContext.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
