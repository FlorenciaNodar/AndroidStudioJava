package com.example.fnodar.nodarflorencia;

import android.view.View;

public class MyListener implements View.OnClickListener {

    MainActivity activity ;

    public MyListener(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        this.activity.adapter.notifyItemChanged(0);
    }
}
