package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SkinProducts extends AppCompatActivity {
    private ListView listView;
    private String[] ProductNames;
    private int[] images={R.drawable.teatreeoil_64x64,R.drawable.teatreefacewash_64x64,R.drawable.teatreepore_64x64,R.drawable.teatreetoner_64x64,R.drawable
    .antiimperfection,R.drawable.the_body_shop_himalayan_charcoal_purifying,R.drawable.cerave_hydrating_cleanse,R.drawable.exfoliant_64x64,
            R.drawable.gelwash,R.drawable.alowcalmfacewash,R.drawable.balancing,R.drawable.seaweedtoner_64x64
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_products);

        ProductNames= getResources().getStringArray(R.array.Products_name);

        listView=findViewById(R.id.listview1);

        CustomAdapter adapter =  new CustomAdapter(this,ProductNames,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = ProductNames[position];
                Toast.makeText(SkinProducts.this,value,Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(SkinProducts.this,TreeTeaOil.class);
                startActivity(intent);
            }
        });
    }
}