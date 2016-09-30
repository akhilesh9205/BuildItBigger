package com.example.androidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_view);
        TextView textView = (TextView) findViewById(R.id.text);
        Intent intent = getIntent();

        String extra = intent.getStringExtra(Extra.EXTRA_TEXT);
        if (extra != null) {
            textView.setText(extra);
        }else{
            textView.setText(String.format("%s needed in Intent Extra.", Extra.EXTRA_TEXT));
        }

    }
}
