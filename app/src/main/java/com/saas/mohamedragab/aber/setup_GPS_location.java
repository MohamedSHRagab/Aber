package com.saas.mohamedragab.aber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class setup_GPS_location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup__gps_location);
        ImageView image =(ImageView)findViewById(R.id.map);
        Animation animation =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        image.startAnimation(animation);




    }

    public void go_sign_up(View view) {
        startActivity(new Intent(this,Sign_up.class));
    }
}
