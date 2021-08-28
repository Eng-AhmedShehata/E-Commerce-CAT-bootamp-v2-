package com.ashehata.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroductionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introdution);
        Button button = findViewById(R.id.btn_skip);

        SharedPreferences sharedPref = this.getSharedPreferences(
                "setting", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref.edit().putBoolean("first_look", true).apply();
                Intent intent = new Intent(IntroductionActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}