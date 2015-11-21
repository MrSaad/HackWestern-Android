package com.mrsaad.hackwestern;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Sponsors extends Fragment {

    public Sponsors() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //set view elements
        View root = inflater.inflate(R.layout.fragment_sponsors, container, false);

        TextView goldTitle = (TextView)root.findViewById(R.id.table_header_title_gold);
        goldTitle.setText("Gold");


        return root;
    }



}
