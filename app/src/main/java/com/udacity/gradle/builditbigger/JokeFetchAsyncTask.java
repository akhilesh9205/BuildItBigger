package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.widget.Toast;


import com.example.myapplication.backend.myJokeApi.MyJokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Akhilesh on 01-10-2016.
 */

public class JokeFetchAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyJokeApi myApiService = null;
    private JokeFetchListener fetchListener;

    public JokeFetchAsyncTask(JokeFetchListener fetchListener) {
        this.fetchListener = fetchListener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyJokeApi.Builder builder = new MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)

                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")

                    .setRootUrl("http://192.168.2.22:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            // end options for devappserver

            myApiService = builder.build();
        }


        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (fetchListener != null) {
            fetchListener.onJokeFetch(result);
            fetchListener = null;
        }
    }
}