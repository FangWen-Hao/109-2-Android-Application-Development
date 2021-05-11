/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.simpleasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * The SimpleAsyncTask class extends AsyncTask to perform a very simple
 * background task -- in this case, it just sleeps for a random amount of time.
 */

public class SimpleAsyncTask extends AsyncTask<Void,Void, String> {

    // The TextView where we will show results
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProBar;
    private WeakReference<Button> Btn;

    // Constructor that provides a reference to the TextView from the MainActivity
    SimpleAsyncTask(Button btn, ProgressBar pb, TextView tv) {
        Btn = new WeakReference<>(btn);
        mProBar = new WeakReference<>(pb);
        mTextView = new WeakReference<>(tv);
    }

    /**
     * Runs on the background thread.
     *
     * @param voids No parameters in this use case.
     * @return Returns the string including the amount of time that
     * the background thread slept.
     */
    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10.
        Random r = new Random();
        int n = r.nextInt(11);
        // Make the task take long enough that we have
        // time to rotate the phone while it is running.
        int s = n * 200;
        int p = s/100;
        // Sleep for the random amount of time.
        try {
            for (int i = 0; i <= 100; i++){
                Thread.sleep(p);
                publishProgress();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result.
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Btn.get().setVisibility(View.INVISIBLE);
        mProBar.get().setVisibility(View.VISIBLE);
        mProBar.get().setProgress(0);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        mProBar.get().incrementProgressBy(1);
    }

    /**
     * Does something with the result on the UI thread; in this case
     * updates the TextView.
     */
    protected void onPostExecute(String result) {
        mProBar.get().setVisibility(View.INVISIBLE);
        Btn.get().setVisibility(View.VISIBLE);
        mTextView.get().setText(result);
    }
}
