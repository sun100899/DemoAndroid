package com.example.demoandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<Book> listBook;
    Context context;
    LayoutInflater inflater;

    public MyAdapter(ArrayList<Book> listBook, Context context) {
        this.listBook = listBook;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.item_book, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvBookName = convertView.findViewById(R.id.tv_item_book);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvBookName.setText(listBook.get(position).getName());

        return convertView;
    }

    class ViewHolder {
        TextView tvBookName;
    }
}
