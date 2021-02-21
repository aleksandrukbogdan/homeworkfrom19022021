package com.company.homework;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products = new ArrayList<>();
    ListView productList;
    EditText newproduct;
    Button btnadd, btndell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (products.size() == 0) {
            products.add(new Product("Картофель", "кг."));
            products.add(new Product("Чай", "шт."));
            products.add(new Product("Яйца", "шт."));
            products.add(new Product("Молоко", "л."));
            products.add(new Product("Макароны", "кг."));
        }
        productList = (ListView) findViewById(R.id.productList);
        final ProductAdapter adapter = new ProductAdapter(this, R.layout.list_item, products);
        productList.setAdapter(adapter);


        btnadd = findViewById(R.id.btnadd);
        btndell = findViewById(R.id.btndell);
        newproduct = findViewById(R.id.newproduct);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = "";
                try {
                    input = newproduct.getText().toString();
                    if (input.equals(""))
                        Toast.makeText(getApplicationContext(), "Пустое поле ввода", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                }
                if (!input.equals(""))
                    products.add(new Product("" + input, "чего-то"));
                newproduct.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        btndell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < products.size(); i++) {
                    adapter.remove(products.get(i));
                }
                productList.clearChoices();
                products.clear();
                adapter.notifyDataSetChanged();

            }
        });

    }


    }
