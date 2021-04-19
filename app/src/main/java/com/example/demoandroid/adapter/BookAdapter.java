package com.example.demoandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoandroid.R;
import com.example.demoandroid.model.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<Book> listBook;

    public BookAdapter(Context context, ArrayList<Book> listBook) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
        this.listBook = listBook;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_book, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Load ảnh, cần cài thư viện Picasso.
        // Nhớ phải có permission INTERNET trong file Manifest nếu không sẽ không load được ảnh
        Picasso.get().load(listBook.get(position).getUrl()).into(holder.thumbnailBook);
        holder.tvBookName.setText(listBook.get(position).getName());
        holder.tvBookAuthor.setText(listBook.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnailBook;
        TextView tvBookName;
        TextView tvBookAuthor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tv_name_item);
            tvBookAuthor = itemView.findViewById(R.id.tv_author_item);
            thumbnailBook = itemView.findViewById(R.id.img_book_item);
        }
    }
}
