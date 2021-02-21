package com.company.homework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter {
    private int layout;
    private LayoutInflater layoutInflater;
    private ArrayList<Product> arrayList;


    public ProductAdapter(Context context, int resource, ArrayList<Product> products) {
        super (context, resource, products);
        this.arrayList = products;
        this.layout = resource;
        this.layoutInflater = LayoutInflater.from(context);


    }


    private class ViewHolder {
        final Button btnplus, btnminus, btndell, btnrem;
        final TextView prcall, prname;

        ViewHolder(View view) {
            prcall = (TextView) view.findViewById(R.id.prcall);
            prname = (TextView) view.findViewById(R.id.prname);
            btnplus = (Button) view.findViewById(R.id.btnplus);
            btnminus = (Button) view.findViewById(R.id.btnminus);
            btndell = (Button) view.findViewById(R.id.btndell);
            btnrem = (Button) view.findViewById(R.id.btnrem);
        }
    }


    private String formatValue(int count, String unit){
        return String.valueOf(count) + " " + unit;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Product product = arrayList.get(position);
        viewHolder.prname.setText(product.getName());
        viewHolder.prcall.setText(formatValue(product.getCall(), product.getUnit()));

        viewHolder.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCall()+1;
                product.setCall(count);
                viewHolder.prcall.setText(formatValue(count, product.getUnit()));
            }    });


        viewHolder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCall()-1;
                if(count<0) count=0;
                product.setCall(count);
                viewHolder.prcall.setText(formatValue(count, product.getUnit()));
               // if (count<0)
                //    arrayList.remove(this);
            }    });

        viewHolder.btnrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(this);

            } });


        return convertView;

    }
}
