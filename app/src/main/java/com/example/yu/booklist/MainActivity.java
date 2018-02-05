package com.example.yu.booklist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BookAdapter bookAdapter;
    private static final String URL_BOOK_GOOGLE_API="https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&1yourAPI1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        BookAsyncTask bookAsyncTask = new BookAsyncTask();
        bookAsyncTask.execute(URL_BOOK_GOOGLE_API);

        bookAdapter = new BookAdapter(this, new ArrayList<Book>());
        list.setAdapter(bookAdapter);


    }
    private class BookAsyncTask extends AsyncTask<String, Void, List<Book>> {

        @Override
        protected List<Book> doInBackground(String... urls) {
            if(urls.length < 1 || urls[0] == null){
                return null;
            }
            List<Book> result = QueryUltils.fetchBookData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            bookAdapter.clear();

            if(books != null && !books.isEmpty()){
                bookAdapter.addAll(books);
            }
        }
    }
}
