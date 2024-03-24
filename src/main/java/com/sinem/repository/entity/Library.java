package com.sinem.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<BaseBook> bookList;
    private List<Member> memberList;
    private List<Long> idList;

    public Library() {
        bookList = new ArrayList<>();
        memberList = new ArrayList<>();
        idList = new ArrayList<>();
    }

    public List<BaseBook> getBookList() {
        return bookList;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void createBookScience(String ISBN, String title, String writer, long publicationDate) {
        long bookId = createRandomNumber();
        BookScience newBookScience = new BookScience();
        newBookScience.setBookId(bookId);
        newBookScience.setISBN(ISBN);
        newBookScience.setTitle(title);
        newBookScience.setWriter(writer);
        newBookScience.setPublicationDate(publicationDate);
        newBookScience.setStatus(EBookStatus.AVAILABLE);
        bookList.add(newBookScience);
    }

    public void createBookNovel(String ISBN, String title, String writer, long publicationDate) {
        long bookId = createRandomNumber();
        BookNovel newBookNovel = new BookNovel();
        newBookNovel.setBookId(bookId);
        newBookNovel.setISBN(ISBN);
        newBookNovel.setTitle(title);
        newBookNovel.setWriter(writer);
        newBookNovel.setPublicationDate(publicationDate);
        newBookNovel.setStatus(EBookStatus.AVAILABLE);
        bookList.add(newBookNovel);
    }

    public void createBookHistory(String ISBN, String title, String writer, long publicationDate) {
        long bookId = createRandomNumber();
        BookHistory newBookHistory = new BookHistory();
        newBookHistory.setBookId(bookId);
        newBookHistory.setISBN(ISBN);
        newBookHistory.setTitle(title);
        newBookHistory.setWriter(writer);
        newBookHistory.setPublicationDate(publicationDate);
        newBookHistory.setStatus(EBookStatus.AVAILABLE);
        bookList.add(newBookHistory);
    }

    public void updateBookStatus(long updatedBookId, String updatedBookStatus) {
        BaseBook rentedBook = null;
        for (BaseBook book : bookList) {
            if (book.getBookId() == updatedBookId) {
                rentedBook = book;
                if (updatedBookStatus.equals("AVAILABLE") || updatedBookStatus.equals("UNAVAILABLE")) {
                    if (EBookStatus.valueOf(updatedBookStatus).equals(EBookStatus.AVAILABLE)) {
                        if (book.getStatus().equals(EBookStatus.AVAILABLE)) {
                            System.out.println("Status of book is already " + EBookStatus.AVAILABLE + "!");
                        } else {
                            book.setStatus(EBookStatus.AVAILABLE);
                            System.out.println("Status of book is set to " + EBookStatus.AVAILABLE);
                            break;
                        }
                    } else if (EBookStatus.valueOf(updatedBookStatus).equals(EBookStatus.UNAVAILABLE)) {
                        if (book.getStatus().equals(EBookStatus.UNAVAILABLE)) {
                            System.out.println("Status of book is already " + EBookStatus.UNAVAILABLE + "!");
                        } else {
                            book.setStatus(EBookStatus.UNAVAILABLE);
                            System.out.println("Status of book is set to " + EBookStatus.UNAVAILABLE);
                            break;
                        }
                    }
                } else {
                    System.out.println("Entered status is not valid!");
                    break;
                }

            }
        }
        if (rentedBook == null) {
            System.out.println("No book found with this ID!");
        }
    }

    public void getAllRentedBooks() {
        BaseBook rentedBook = null;
        for (BaseBook book : bookList) {
            if (book.getStatus().equals(EBookStatus.RENTED)) {
                rentedBook = book;
                System.out.println(book);
            }
        }
        if (rentedBook == null) {
            System.out.println("No rented books found!");
        }
    }

    public long createRandomNumber() {
        long randomNumber;
        do {
            randomNumber = (long) (Math.random() * 100 + 1);
            idList.add(randomNumber);
        } while (!(idList.contains(randomNumber)));
        return randomNumber;
    }

    public void getAvailableBooks() {
        for (BaseBook book : bookList) {
            if (book.getStatus().equals(EBookStatus.AVAILABLE)) {
                System.out.println(book);
            }
        }
    }

    public void createMember(String nameSurname) {
        long memberId = createRandomNumber();
        Member newMember = new Member();
        newMember.setMemberId(memberId);
        newMember.setNameSurname(nameSurname);
        memberList.add(newMember);
        System.out.println("New member added: " + newMember.getNameSurname() + " ID: " + memberId);
    }

    public void rentBook(long bookId, long memberId) {
        Member searchedMember = null;
        BaseBook searchedBook = null;
        for (Member member : memberList) {
            if (member.getMemberId() == memberId) {
                searchedMember = member;
                for (BaseBook book : bookList) {
                    if (book.getBookId() == bookId) {
                        if (book.getStatus().equals(EBookStatus.AVAILABLE)) {
                            searchedMember.getRentedBookList().add(book);
                            searchedBook = book;
                            book.setStatus(EBookStatus.RENTED);
                            System.out.println(book.getTitle() + " book is rented to member: " + searchedMember.getNameSurname());
                        } else {
                            System.out.println("Sorry, this book is not available!");
                        }
                    }
                }
                if (searchedBook == null) {
                    System.out.println("Book not found with this ID!");
                    break;
                }
            }
        }
        if (searchedMember == null) {
            System.out.println("Member not found with this ID!");
        }
    }

    public void returnBook(long bookId, long memberId) {
        Member searchedMember = null;
        BaseBook searchedBook = null;
        for (Member member : memberList) {
            if (member.getMemberId() == memberId) {
                searchedMember = member;
                List<BaseBook> rentedBookList = searchedMember.getRentedBookList();
                System.out.println("rented book list is: " + rentedBookList);
                for (BaseBook book : rentedBookList) {
                    if (book.getBookId() == bookId) {
                        if (book.getStatus().equals(EBookStatus.RENTED)) {
                            searchedBook = book;
                            searchedMember.getRentedBookList().remove(book);
                            book.setStatus(EBookStatus.AVAILABLE);
                            System.out.println(book.getTitle() + "book is returned by member: " + searchedMember.getNameSurname());
                            break;
                        } else {
                            System.out.println("Book " + book.getTitle() + " is not rented by member " + searchedMember.getNameSurname());
                        }
                    }
                }
                if (searchedBook == null) {
                    System.out.println("Book not found with this ID!");
                    break;
                }
            }
        }
        if (searchedMember == null) {
            System.out.println("Member not found with this ID!");
        }
    }

    public void getRentedBooks(long memberId) {
        Member searchedMember = null;
        BaseBook rentedBook = null;
        for (Member member : memberList) {
            if (member.getMemberId() == memberId) {
                searchedMember = member;
                List<BaseBook> rentedBookList = searchedMember.getRentedBookList();
                for (BaseBook book : rentedBookList) {
                    rentedBook = book;
                    System.out.println(book);
                }
                if (rentedBook == null) {
                    System.out.println("Rented book not found with this member ID!");
                }
            }
        }
        if (searchedMember == null) {
            System.out.println("Member not found with this ID!");
        }
    }
}
