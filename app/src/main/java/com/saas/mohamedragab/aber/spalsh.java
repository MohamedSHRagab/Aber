package com.saas.mohamedragab.aber;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class spalsh extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
              go_intro();
            }

        }, SPLASH_DISPLAY_LENGTH);

    }
    public void go_intro(){
        Intent mainIntent = new Intent(this,intro.class);
        startActivity(mainIntent);
        finish();
    }
}
