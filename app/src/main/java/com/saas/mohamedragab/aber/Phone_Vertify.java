package com.saas.mohamedragab.aber;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Phone_Vertify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone__vertify);

    }

    public void go_home_page(View view) {
        Intent mainIntent = new Intent(this,Home_online.class);
        startActivity(mainIntent);
        finish();
    }
}
