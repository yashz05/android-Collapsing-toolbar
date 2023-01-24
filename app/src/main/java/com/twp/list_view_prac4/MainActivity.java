package com.twp.list_view_prac4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_2);
        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        ListView ll = findViewById(R.id.listitems);
        Button click = findViewById(R.id.btn);
        ImageView img = findViewById(R.id.img);
        ArrayList<String> slctedlangs = new ArrayList<>();


        String languages[] = {"Java", "Android", "PHP", "HTML", "Dart"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, languages);
        ll.setAdapter(ad);
        ll.setNestedScrollingEnabled(true);

        ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                slctedlangs.add(((TextView) view).getText().toString());


            }

        });


        click.setOnClickListener(e -> {
            Log.d("TAG", "onCreate: " + slctedlangs);
            Intent ne = new Intent(MainActivity.this, new_page.class);
            ne.putExtra("list", slctedlangs.toString());
            ne.putExtra("email", email.getText().toString());
            ne.putExtra("name", name.getText().toString());


            startActivity(ne);
        });


    }
}