package com.sinem.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class Member implements IMember{
    private long memberId;
    private String nameSurname;
    private List<BaseBook> rentedBookList;

    public Member() {
        rentedBookList = new ArrayList<>();
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public List<BaseBook> getRentedBookList() {
        return rentedBookList;
    }

    public void setRentedBookList(List<BaseBook> rentedBookList) {
        this.rentedBookList = rentedBookList;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId +
                ", Name Surname: '" + nameSurname + '\'' ;
    }
}
