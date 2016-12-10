package com.example.randolph.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Category extends AppCompatActivity {

    private EditText edt_ctg, edt_percent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        edt_ctg = (EditText)findViewById(R.id.edt_category);
        edt_percent = (EditText)findViewById(R.id.edt_percent);
    }
}
