package app.com.kaisersource.meteorest.Splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import app.com.kaisersource.meteorest.Home.HomeView;
import app.com.kaisersource.kotlinweather.R;

public class Splash extends Activity {

        private static int SPLASH_TIME_OUT = 4000;

        private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        iv=(ImageView)findViewById(R.id.gifgraph);
        Glide.with(this).load(R.drawable.splash).into(iv);


        new Handler().postDelayed(new Runnable(){
        @Override
        public void run(){
            Intent homeIntent = new Intent(Splash.this, HomeView.class);
             startActivity(homeIntent);
            finish();
        }
    },SPLASH_TIME_OUT);

    }
}
