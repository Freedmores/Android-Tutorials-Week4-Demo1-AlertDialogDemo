package com.sidume.freedmores.alertdialogdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView_languages_chosen);
        Intent intent = getIntent();

        String retrived_string = intent.getStringExtra("known_languages");
        textView.setText(retrived_string);
    }
}
