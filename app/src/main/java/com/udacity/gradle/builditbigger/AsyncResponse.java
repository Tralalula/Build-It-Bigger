// In order to get output from EndpointsAsyncTask I used code from the following link: http://stackoverflow.com/questions/12575068/
package com.udacity.gradle.builditbigger;

/**
 * Created by Tobias on 27-12-2015.
 */
public interface AsyncResponse {
    void processFinish(String output);
}
