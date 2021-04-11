package com.example.intentconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBookScreen extends AppCompatActivity {
    EditText edtBookName;
    EditText edtAuthor;
    Button btnAdd;

    static final int RESULT_ADD_BOOK_OK = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_screen);

        initView();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtBookName.getText().toString();
                String author = edtBookName.getText().toString();

                Log.d("TAG", "HELLO");
                Intent intent = new Intent();
                intent.putExtra("bookName", name);
                intent.putExtra("authorName", author);
                setResult(RESULT_ADD_BOOK_OK, intent);
                finish();
            }
        });

    }

    void initView() {
        edtAuthor = findViewById(R.id.edtAuthor);
        edtBookName = findViewById(R.id.edtName);
        btnAdd = findViewById(R.id.btnAdd);
    }
}