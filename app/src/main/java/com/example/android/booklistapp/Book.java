package com.example.android.booklistapp;

/**
 * Created by Gerasimos on 15/7/2017.
 */

public class Book {
    private String mAuthor;
    private String mTitle;
    private String mMainCategory;

    public Book(String author,String title,String mMainCategory){
        this.mAuthor = author;
        this.mTitle = title;
        this.mMainCategory = mMainCategory;
    }

    public String getmAuthor(){
        return mAuthor;
    }

    public String getmTitle(){
        return mTitle;
    }

    public String getmMainCategory(){
        return mMainCategory;
    }
}
