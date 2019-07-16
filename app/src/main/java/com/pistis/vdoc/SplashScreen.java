package com.pistis.vdoc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.pistis.vdoc.activities.SintomaActivity;

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R;

public class SplashScreen extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };*/

        //myThread.start();

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,SintomaActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);


        /*new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(SplashScreen.this, MainActivity.class);

                startActivity(i);

                // close this activity

                finish();

            }

        }, 4*1000); // wait for 5 seconds*/
    }
}
