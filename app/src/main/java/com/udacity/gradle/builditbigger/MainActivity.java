package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.androidlibrary.Extra;
import com.example.androidlibrary.JokeViewActivity;


public class MainActivity extends AppCompatActivity implements JokeFetchListener{

    private View button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        button = view;
        view.setEnabled(false);
        new JokeFetchAsyncTask(this).execute();

    }


    @Override
    public void onJokeFetch(String joke) {
        if (button != null) {
            button.setEnabled(true);
        }
        Intent intent = new Intent(this, JokeViewActivity.class);
        intent.putExtra(Extra.EXTRA_TEXT, joke);
        startActivity(intent);
    }
}
