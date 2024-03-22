package com.sinem.repository.entity;

public class BookScience extends BaseBook {
    private EBookStatus status;

    public EBookStatus getStatus() {
        return status;
    }

    public void setStatus(EBookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return '\n' + "Science Book {" +
                "bookId=" + getBookId() +
                ", ISBN='" + getISBN() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", writer='" + getWriter() + '\'' +
                ", publicationDate=" + getPublicationDate() +
                ", status=" + getStatus() +
                '}'
                ;
    }
}
