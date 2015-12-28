// Used code from the following: http://stackoverflow.com/questions/2321829/
package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tobias on 27-12-2015.
 */
public class EndpointsAsyncTaskTest extends ApplicationTestCase<Application> implements AsyncResponse {
    CountDownLatch signal;
    String joke;

    public EndpointsAsyncTaskTest() {
        super(Application.class);
    }

    /**
     * Test that your Async task successfully retrieves a non-empty string.
     */
    public void testNonEmptyString() throws InterruptedException {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.delegate = this;
        signal = new CountDownLatch(1);
        endpointsAsyncTask.execute();
        signal.await(30, TimeUnit.SECONDS);
        assertFalse("String is null!", joke == null);
    }

    public void processFinish(String output) {
        joke = output;
        signal.countDown();
    }
}
