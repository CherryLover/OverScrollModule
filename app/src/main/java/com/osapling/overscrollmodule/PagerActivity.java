package com.osapling.overscrollmodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PagerActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, PagerActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
    }
}
