package com.example.emanuele.gino;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private static int SPLASH_TIME_OUT = 4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intent per lo splash screen
        new Handler().postDelayed(new Runnable(){
        @Override
        public void run(){
            Intent homeIntent = new Intent(MainActivity.this,HomeActivity.class);
             startActivity(homeIntent);
            finish();
        }
    },SPLASH_TIME_OUT);

    }

}
