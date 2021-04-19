package com.example.demoandroid.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.demoandroid.R;
import com.example.demoandroid.adapter.BookAdapter;
import com.example.demoandroid.model.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvListBook;
    ArrayList<Book> listBook = new ArrayList<>();
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvListBook = findViewById(R.id.lst_book);

        initFakeData();

        rcvListBook.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcvListBook.setLayoutManager(layoutManager);
        bookAdapter = new BookAdapter(this, listBook);
        rcvListBook.setAdapter(bookAdapter);

    }


    void initFakeData() {
        Book conan = new Book("Conan detective", "https://kilala.vn/data/upload/article/5493/Conan%20movie%20Cu%20dam%20Sapphire%20xanh.png",  "Aoyama Gosho");
        Book naruto = new Book("Naruto Shippuden", "https://gamek.mediacdn.vn/133514250583805952/2020/2/26/photo-1-15827070847125071669.jpeg",  "Kishimoto Masashi");
        Book onepiece = new Book("One Piece", "https://genk.mediacdn.vn/2019/11/17/anh-1-1573993861741826606968.png",  "Oda Eiichiro");
        Book kaito = new Book("Kuroba Kaito", "https://i.pinimg.com/originals/5b/31/b5/5b31b5fc8cc2a822515bae869ff9db9e.png",  "Oda Eiichiro");
        Book doraemon = new Book("Doraemon", "https://htv3tv.vn/wp-content/uploads/2020/02/Doraemon-Screaming-900x506.jpg",  "Fujiko F. Fujio");
        for (int i = 1; i< 5; i++) {
            listBook.add(conan);
            listBook.add(naruto);
            listBook.add(onepiece);
            listBook.add(kaito);
            listBook.add(doraemon);
        }
    }
}