package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText email,password;
    private Button login,signup;
    private TextView textView1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.emailid);
        password=findViewById(R.id.passwordid);
        login=findViewById(R.id.loginbuttonid);
        signup=findViewById(R.id.signupbuttonid);
        textView1=findViewById(R.id.textview1id);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginbuttonid :

                userlogin();
                break;

            case R.id.signupbuttonid:
                Intent intents= new Intent(getApplicationContext(),SignUp.class);
                startActivity(intents);
                break;

        }

    }

    private void userlogin() {
        String Email= email.getText().toString().trim();

        String Passwords= password.getText().toString().trim();

        if(Email.isEmpty())
        {
            email.setError("Enter an email address");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            email.setError("Enter a valid email address");
            email.requestFocus();
            return;
        }

        //checking the validity of the password
        if(Passwords.isEmpty())
        {
            password.setError("Enter a password");
            password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(Email,Passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    finish();
                    Intent intent = new Intent(MainActivity.this,HairOrskin.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login unsuccessful",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}