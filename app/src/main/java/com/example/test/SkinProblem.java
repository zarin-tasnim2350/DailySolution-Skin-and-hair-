package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SkinProblem extends AppCompatActivity {

    private TextView ProblemChoice,clickButton;
    private CheckBox AcneProne,Oily,AcneScar,Pigmentation;
    private Button clickHereButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_problem);

        ProblemChoice=findViewById(R.id.typeid);
        clickButton=findViewById(R.id.clickbuttongetsolution);
        AcneProne=findViewById(R.id.acneid);
        Oily=findViewById(R.id.oilyid);
        AcneScar=findViewById(R.id.scarsid);
        Pigmentation=findViewById(R.id.pigmentationid);
        clickHereButton=findViewById(R.id.solutionid);

        clickHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clickbutton= new Intent(getApplicationContext(),SkinProducts.class);
                startActivity(clickbutton);
            }
        });


    }
}