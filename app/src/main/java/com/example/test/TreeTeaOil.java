package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TreeTeaOil extends AppCompatActivity {

    private TextView textView1,textView2;
    private EditText editText1,editText2;
    private Button cartbutton;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_tea_oil);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        textView1= findViewById(R.id.textviewoneid);
        textView2=findViewById(R.id.textviewtwoid);
        editText1=findViewById(R.id.oilteatreeid);
        editText2=findViewById(R.id.quantityid);
        cartbutton=findViewById(R.id.cartbuttonid);

        cartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTocart();
                Intent addtocart= new Intent(getApplicationContext(),Finishline.class);
                startActivity(addtocart);
            }



            
        });
    }

    private void addTocart() {
        String editTextone=editText1.getText().toString().trim();
        String editTexttwo=editText2.getText().toString().trim();

        String key = databaseReference.push().getKey();

        cart Cart= new cart(editTextone,editTexttwo);
        databaseReference.child(key).setValue(Cart);
        Toast.makeText(getApplicationContext(),"successfully add data",Toast.LENGTH_SHORT).show();
    }
}