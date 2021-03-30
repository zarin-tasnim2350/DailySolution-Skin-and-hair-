package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText email,usernamesingup,passwordsignup,confirmpasssignup;
    private Button signinButton,registerButton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        registerButton=findViewById(R.id.registerid);
        email=findViewById(R.id.emailid);
        usernamesingup=findViewById(R.id.userid);
        passwordsignup=findViewById(R.id.passid);
        confirmpasssignup=findViewById(R.id.confirmpassid);
        signinButton=findViewById(R.id.signupid);
        signinButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signupid:
                Intent intent1= new Intent(SignUp.this,MainActivity.class);
                startActivity(intent1);


                break;
            case R.id.registerid:
                userRegister();


                break;

        }

    }

    private void userRegister() {
        String Email= email.getText().toString().trim();
        String UserNames= usernamesingup.getText().toString().trim();
        String Passwords= passwordsignup.getText().toString().trim();
        String ConfirmPassword= confirmpasssignup.getText().toString().trim();

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
            passwordsignup.setError("Enter a password");
            passwordsignup.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(Email,Passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Register is successfull",Toast.LENGTH_SHORT).show();



                } else {
                    Toast.makeText(getApplicationContext(),"Register is not successfull",Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}