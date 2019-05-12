package com.example.jayeshsharma.basketballscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Bundle bn=getIntent().getBundleExtra("data");
        BbAdapter adapter=new BbAdapter(this,(ArrayList<data>)bn.getSerializable("data"));
        ListView listView=(ListView)findViewById(R.id.list_item);
        listView.setAdapter(adapter);
    }

}
