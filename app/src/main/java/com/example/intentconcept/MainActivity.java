package com.example.intentconcept;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lvListView;
    private ArrayList<Book> listBook = new ArrayList<>();
    BookAdapter bookAdapter;

    static final int REQUEST_ADD_NEW_BOOK = 1;
    static final int REQUEST_EDIT_NEW_BOOK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        bookAdapter = new BookAdapter(listBook, MainActivity.this);
        lvListView.setAdapter(bookAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBookScreen.class);
                startActivityForResult(intent, REQUEST_ADD_NEW_BOOK);
            }
        });

        lvListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = listBook.get(position);
                Intent intent = new Intent(MainActivity.this, EditBook.class);
                intent.putExtra("book", book);
                startActivityForResult(intent, REQUEST_EDIT_NEW_BOOK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ADD_NEW_BOOK) {
            if(resultCode == AddBookScreen.RESULT_ADD_BOOK_OK) {
                String name = data.getStringExtra("bookName");
                String author = data.getStringExtra("authorName");
                Book newBook = new Book(name, author);
                listBook.add(newBook);
                bookAdapter.notifyDataSetChanged();
            }
        }
        if(requestCode == REQUEST_EDIT_NEW_BOOK) {

        }
    }

    void initView() {
        btnAdd = findViewById(R.id.btnAddBook);
        lvListView = findViewById(R.id.lvListBook);
    }
}