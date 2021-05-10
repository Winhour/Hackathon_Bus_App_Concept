package com.example.san.projekt;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class TimerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        final TextView PoleTimer = findViewById(R.id.textView2);
        final TextView Punkciki = findViewById(R.id.textView4);

        Punkciki.setText(""+GlobalVariables.CPkt);


        new CountDownTimer(900000, 1000) {

            public void onTick(long millisUntilFinished) {
                GlobalVariables.isRunning = true;
                PoleTimer.setText(""+String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));


            }

            public void onFinish() {
                GlobalVariables.isRunning = false;
                PoleTimer.setText("Aktywuj aplikacje ponownie");
            }

        }.start();



        GlobalVariables.handler.removeCallbacksAndMessages(null);
        GlobalVariables.handler.postDelayed(new Runnable() {
            public void run() {
                if (GlobalVariables.isRunning == true){
                    GlobalVariables.CPkt++;
                    Punkciki.setText(""+GlobalVariables.CPkt);
                }

                GlobalVariables.handler.postDelayed(this, 5000);
            }
        }, 5000);




    }


}
