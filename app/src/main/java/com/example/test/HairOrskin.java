package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HairOrskin extends AppCompatActivity {

    private TextView choice,HairProblem,SkinProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_orskin);

        choice= findViewById(R.id.hairNskinid);
        HairProblem=findViewById(R.id.hairid);
        SkinProblem=findViewById(R.id.skinid);

        SkinProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenth= new Intent(HairOrskin.this, com.example.test.SkinProblem.class);
                startActivity(intenth);
            }
        });
    }
}