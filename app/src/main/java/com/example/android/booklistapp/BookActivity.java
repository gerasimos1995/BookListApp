package com.example.android.booklistapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private static final String USGS_REQUEST_URL="https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&key=yourAPIKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookASsncTask task = new BookASsncTask();
        // Update the information displayed to the user.
        task.execute(USGS_REQUEST_URL);
    }

    private class BookASsncTask extends AsyncTask<String,Void,Book> {
        @Override
        protected Book doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            Book result = QueryUtils.fetchBookData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(Book result) {
            // If there is no result, do nothing.
            if (result == null) {
                return;
            }

            // Find a reference to the {@link ListView} in the layout
            ListView bookListView = (ListView) findViewById(R.id.activity_main);

            // Create a new adapter that takes an empty list of books as input
            bookAdapter = new BookAdapter(this, new ArrayList<Book>());

            // Set the adapter on the {@link ListView}
            // so the list can be populated in the user interface
            bookListView.setAdapter(bookAdapter);
        }
    }
}
