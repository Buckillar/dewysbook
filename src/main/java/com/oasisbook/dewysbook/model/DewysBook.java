package com.oasisbook.dewysbook.model;

public class DewysBook
{
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookYear;


    public DewysBook()
    {

    }


    //Constructor
    public DewysBook(String bookId, String bookTitle, String bookAuthor, String bookYear)
    {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }


    // getter and setters
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

}
