package com.example.android.booklistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gerasimos on 15/7/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, List<Book> books){
        super(context,0,books);
    }

    /**
     * Returns a list item view that displays information about the book at the given position
     * in the list of books.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        // Find the book at the given position in the list of books
        Book currentBook = getItem(position);

        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author_text_view);
        // Display the author of the current book in that TextView
        authorView.setText(currentBook.getmAuthor());

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Display the title of the current book in that TextView
        titleView.setText(currentBook.getmTitle());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
