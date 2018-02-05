package com.example.yu.booklist;

/**
 * Created by cpu11268-local on 30/01/2018.
 */

public class Book {
    private String title;
    private String authors;
    private String publishDate;
    private String urlImage;

    public Book(String title, String authors, String publishDate, String urlImage) {
        this.title = title;
        this.authors = authors;
        this.publishDate = publishDate;
        this.urlImage = urlImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
