package com.saas.mohamedragab.aber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void go_home_page(View view) {
        Intent mainIntent = new Intent(this,Phone_Vertify.class);
        startActivity(mainIntent);
        finish();
    }
}
