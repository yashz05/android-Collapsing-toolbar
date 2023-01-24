package com.twp.list_view_prac4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class new_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_page);
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String name = intent.getStringExtra("name");
        String value = intent.getStringExtra("list");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String replace = value.replace("[", "").replace("]", "");
        String[] slt = replace.split(",");
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, slt);

        ListView LL = findViewById(R.id.listvieww);
        TextView namee = findViewById(R.id.name);
        TextView emaill = findViewById(R.id.email);

        namee.setText(name.toString());
        emaill.setText(email.toString());

        LL.setAdapter(ad);

    }
}