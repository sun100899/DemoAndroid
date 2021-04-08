package com.example.demoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Screen2 extends AppCompatActivity {
    ListView listView;

    private ArrayList<Book> listBook = new ArrayList<>();

    void initData() {
        for(int i = 1; i<= 10; i++) {
            Book book = new Book("Book number: " + i);
            listBook.add(book);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        listView = findViewById(R.id.listview);

        initData();

        MyAdapter myAdapter = new MyAdapter(listBook, Screen2.this);
        listView.setAdapter(myAdapter);

    }
}