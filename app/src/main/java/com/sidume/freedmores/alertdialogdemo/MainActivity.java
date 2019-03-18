package com.sidume.freedmores.alertdialogdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity{
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final ArrayList<Integer> selList=new ArrayList<Integer>();
        final ArrayList<String> languages = new ArrayList<String>(
                Arrays.asList(getResources().getStringArray(R.array.languages))
        );
        boolean bl[] = new boolean[getResources().getStringArray(R.array.languages).length];


        builder.setTitle(R.string.dialog_title)

                .setMultiChoiceItems(getResources().getStringArray(R.array.languages),bl ,new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked)
                        {
                            // If user select a item then add it in selected items
                            selList.add(which);
                        }
                        else if (selList.contains(which))
                        {
                            // if the item is already selected then remove it
                            selList.remove(Integer.valueOf(which));
                        }
                    }

                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String chosen_languages="";

                        for (int i=0; i<selList.size(); i++){
                            chosen_languages += languages.get(selList.get(i)) +"\n";
                        }

                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        intent.putExtra("known_languages",chosen_languages);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog ad = builder.create();
                ad.show();
            }
        });


    }


}
