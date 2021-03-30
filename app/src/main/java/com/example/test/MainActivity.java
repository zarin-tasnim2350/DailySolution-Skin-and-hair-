package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username,password;
    private Button login,signup;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.usernameid);
        password=findViewById(R.id.passwordid);
        login=findViewById(R.id.loginbuttonid);
        signup=findViewById(R.id.signupbuttonid);
        textView1=findViewById(R.id.textview1id);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents= new Intent(MainActivity.this,SignUp.class);
                startActivity(intents);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName= username.getText().toString();
                String passWord= password.getText().toString();
                if (userName.equals("zarin") && passWord.equals("1234")){

                    Intent intent= new Intent(MainActivity.this,HairOrskin.class);
                    startActivity(intent);

                 }


                else{

                    Toast toast1= Toast.makeText(MainActivity.this,"Incorrect username or password",Toast.LENGTH_SHORT);
                    toast1.show();


                }

            }


        });

    }
}