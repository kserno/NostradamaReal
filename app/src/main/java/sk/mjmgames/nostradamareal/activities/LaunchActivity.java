package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;

import sk.mjmgames.nostradamareal.R;

/**
 * Created by Filip on 30.7.2015.
 */
public class LaunchActivity extends Activity {

    private ProgressBar _progressBar;
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);


        final Intent intent = new Intent(this, MainActivity.class);

        _progressBar = (ProgressBar) findViewById(R.id.progressBar);


        Thread thread = new Thread() {
            @Override
            public void run() {
                while (counter<100) {
                    counter += 1;
                    _progressBar.setProgress(counter);
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(intent);
            }
        };
        thread.start();



    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
