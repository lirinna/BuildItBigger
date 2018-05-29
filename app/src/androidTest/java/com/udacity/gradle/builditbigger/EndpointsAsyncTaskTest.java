package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CountDownLatch.html
//https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Test
    public void testAsyncTask() throws InterruptedException{

        final CountDownLatch startSignal = new CountDownLatch(1);
        MainActivityFragment fragment = new MainActivityFragment();

        final EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(fragment.getContext()) {

            @Override
            protected void onPostExecute(String result) {
                   startSignal.countDown();
            }
        };

        String resultTest = null;
        endpointsAsyncTask.execute();
        startSignal.await();

        try {
            resultTest = endpointsAsyncTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertNotNull(resultTest);
        assertTrue(resultTest.length() > 0);
    }
}