package com.sinem.repository.entity;

abstract class BaseBook {
    private long bookId;
    private String ISBN;
    private String title;
    private String writer;
    private long publicationDate;
    private EBookStatus status;

    public EBookStatus getStatus() {
        return status;
    }

    public void setStatus(EBookStatus status) {
        this.status = status;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public long getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(long publicationDate) {
        this.publicationDate = publicationDate;
    }


}
