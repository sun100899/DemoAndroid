package com.example.demoandroid;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class BookDetail extends AppCompatActivity {

    TextView tvBookName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvBookName = findViewById(R.id.tvBookName);

        // String receiveName = getIntent().getStringExtra("bookName");
        Bundle bundle = getIntent().getBundleExtra("bundle");
        int idBook = bundle.getInt("idBook");
        String bookName = bundle.getString("bookName");

        tvBookName.setText(bookName);
    }
}