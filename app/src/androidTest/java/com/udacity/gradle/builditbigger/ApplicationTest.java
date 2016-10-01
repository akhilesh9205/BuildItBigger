package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private String mJoke;

    public ApplicationTest() {
        super(Application.class);
    }


    // fetch joke AsyncTask test
    public void testFetchJokeAsync() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        new JokeFetchAsyncTask(new JokeFetchListener() {
            @Override
            public void onJokeFetch(String joke) {
                mJoke = joke;
                latch.countDown();
            }
        }).execute();

        latch.await();
        Log.d("TESTING", mJoke);
        assertFalse(TextUtils.isEmpty(mJoke));
    }
}