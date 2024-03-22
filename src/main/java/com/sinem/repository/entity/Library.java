package com.sinem.repository.entity;

import java.util.ArrayList;
import java.util.List;

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

    public long createRandomNumber() {
        long randomNumber;
        do {
            randomNumber = (long)(Math.random()*100 + 1);
            idList.add(randomNumber);
        } while (!(idList.contains(randomNumber)));
        return randomNumber;
    }

    public void createMember(String nameSurname) {
        long memberId = createRandomNumber();
        Member newMember = new Member();
        newMember.setMemberId(memberId);
        newMember.setNameSurname(nameSurname);
        memberList.add(newMember);
    }

    public void rentBook(long bookId, long memberId) {
        for (BaseBook book: bookList) {

        }
    }
}
