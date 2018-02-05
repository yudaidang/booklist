package com.example.yu.booklist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cpu11268-local on 30/01/2018.
 */

public class BookAdapter extends ArrayAdapter<Book> {
    ViewHolder viewHolder;
    public BookAdapter(@NonNull Context context, List<Book> resource) {
        super(context, 0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.author = (TextView) listItemView.findViewById(R.id.author);
            viewHolder.title = (TextView) listItemView.findViewById(R.id.title);
            viewHolder.publishDate = (TextView) listItemView.findViewById(R.id.publishDate);
            listItemView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) listItemView.getTag();
        }
        Book book = getItem(position);
        viewHolder.title.setText(book.getTitle());

        viewHolder.author.setText(book.getAuthors());

        viewHolder.publishDate.setText(book.getPublishDate());


        return listItemView;
    }


    class ViewHolder {
        private TextView title;
        private TextView author;
        private TextView publishDate;
    }



}
