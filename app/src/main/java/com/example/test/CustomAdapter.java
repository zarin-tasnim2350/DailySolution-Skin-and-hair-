package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] images;
    String[] ProductNames;
    Context context;
    private LayoutInflater layoutInflater;
    CustomAdapter(Context context,String[] ProductNames,int[] images){
        this.context=context;
        this.ProductNames=ProductNames;
        this.images=images;


    }

    @Override
    public int getCount() {
        return ProductNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
          layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=  layoutInflater.inflate(R.layout.sample,parent,false);
        }

      ImageView view= convertView.findViewById(R.id.imageviewid);
      TextView textView= convertView.findViewById(R.id.productnameid);

      view.setImageResource(images[position]);
      textView.setText(ProductNames[position]);

        return convertView;
    }
}
