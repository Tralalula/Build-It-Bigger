// In order to get output from EndpointsAsyncTask I used code from the following link: http://stackoverflow.com/questions/12575068/
package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.tobias.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Tobias on 27-12-2015.
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    public AsyncResponse delegate = null;
    private static MyApi myApiService;

    public EndpointsAsyncTask() {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("https://builditbigger-1172.appspot.com/_ah/api/");
        myApiService = builder.build();
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }
}