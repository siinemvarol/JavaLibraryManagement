package com.sinem;

import com.sinem.repository.entity.BookScience;
import com.sinem.repository.entity.EBookStatus;
import com.sinem.repository.entity.Library;
import com.sinem.repository.entity.Member;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LibraryManagementApplication {

    public static void showMenu() {
        System.out.println("\n- - - WELCOME TO TRINITY LIBRARY! - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println("Choose from below:");
        System.out.println("1 - Add new science book");
        System.out.println("2 - Add new novel");
        System.out.println("3 - Add new history book");
        System.out.println("4 - Update book status");
        System.out.println("5 - Show all rented books");
        System.out.println("6 - Show all books");
        System.out.println("7 - Create a new member");
        System.out.println("8 - Show all members");
        System.out.println("9 - Rent a book");
        System.out.println("10 - Return a book");
        System.out.println("11 - Show rented books of a member");
        System.out.println("0 - Exit program");
    }

    public static boolean showMenuAgain = true;

    public static void main(String[] args) {

        Library library = new Library();
        library.createBookScience("978-0199219223", "On the Origin of Species", "Charles Darwin", 2008);
        library.createBookScience("978-0691125756", "QED – Strange Theory of Light and Matter", "Richard P Feynman", 2006);
        library.createBookScience("978-0521437769", "On Growth and Form", "D'Arcy Wentworth Thompson", 1992);
        library.createBookNovel("978-0142437230", "Don Quixote", "Miguel De Cervantes Saavedra", 2003);
        library.createBookNovel("978-1948481120", "The Pilgrim's Progress", "John Bunyan", 2020);
        library.createBookNovel("978-1853260452", "Robinson Crusoe", "Daniel Defoe", 1997);
        library.createBookHistory("978-0195398663", "John Adams: A Life", "John Ferling", 2010);
        library.createBookHistory("978-0241387481", "The Diary Of A Young Girl", "Anne Frank", 2019);
        library.createBookHistory("978-0140437645", "The History of the Decline and Fall of the Roman Empire", "David P. Womersley", 2001);

        library.createMember("Sinem Varol");
        library.createMember("Yasemin Varol");
        library.createMember("Batuhan Deniz Karagöz");

        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            switch (Integer.valueOf(scanner.nextLine())) {
                case 1:
                    System.out.println("Enter ISBN: ");
                    String scienceISBN = scanner.nextLine();
                    System.out.println("Enter title: ");
                    String scienceTitle = scanner.nextLine();
                    System.out.println("Enter writer: ");
                    String scienceWriter = scanner.nextLine();
                    System.out.println("Enter publication date: ");
                    long sciencePublicationDate = Long.valueOf(scanner.nextLine());
                    library.createBookScience(scienceISBN, scienceTitle, scienceWriter, sciencePublicationDate);
                    break;
                case 2:
                    System.out.println("Enter ISBN: ");
                    String novelISBN = scanner.nextLine();
                    System.out.println("Enter title: ");
                    String novelTitle = scanner.nextLine();
                    System.out.println("Enter writer: ");
                    String novelWriter = scanner.nextLine();
                    System.out.println("Enter publication date: ");
                    long novelPublicationDate = Long.valueOf(scanner.nextLine());
                    library.createBookScience(novelISBN, novelTitle, novelWriter, novelPublicationDate);
                    break;
                case 3:
                    System.out.println("Enter ISBN: ");
                    String historyISBN = scanner.nextLine();
                    System.out.println("Enter title: ");
                    String historyTitle = scanner.nextLine();
                    System.out.println("Enter writer: ");
                    String historyWriter = scanner.nextLine();
                    System.out.println("Enter publication date: ");
                    long historyPublicationDate = Long.valueOf(scanner.nextLine());
                    library.createBookScience(historyISBN, historyTitle, historyWriter, historyPublicationDate);
                    break;
                case 4:
                    System.out.println("Enter book ID: ");
                    long updatedBookId = Long.valueOf(scanner.nextLine());
                    System.out.println("Enter new status: (AVAILABLE, RENTED, UNAVAILABLE)");
                    String updatedBookStatus = scanner.nextLine();
                    if (updatedBookStatus.equals("RENTED")) {
                        System.out.println("Enter member ID: ");
                        long rentalMemberId = Long.valueOf(scanner.nextLine());
                        library.rentBook(updatedBookId, rentalMemberId);
                    } else {
                        library.updateBookStatus(updatedBookId, updatedBookStatus);
                    }
                    break;
                case 5:
                    library.getAllRentedBooks();
                    break;
                case 6:
                    System.out.println(library.getBookList());
                    break;
                case 7:
                    System.out.println("Enter name and surname: ");
                    String memberNameSurname = scanner.nextLine();
                    library.createMember(memberNameSurname);
                    break;
                case 8:
                    for (Member currentMember : library.getMemberList()) {
                        System.out.println(currentMember.toString());
                    }
                    break;
                case 9:
                    library.getAvailableBooks();
                    System.out.println("Enter book ID: ");
                    long rentalBookId = Long.valueOf(scanner.nextLine());
                    System.out.println("Enter member ID: ");
                    long rentalMemberId = Long.valueOf(scanner.nextLine());
                    library.rentBook(rentalBookId, rentalMemberId);
                    break;
                case 10:
                    System.out.println("Enter book ID: ");
                    long returnBookId = Long.valueOf(scanner.nextLine());
                    System.out.println("Enter member ID: ");
                    long returnMemberId = Long.valueOf(scanner.nextLine());
                    library.returnBook(returnBookId, returnMemberId);
                    break;
                case 11:
                    System.out.println("Enter member ID: ");
                    long rentedBooksMemberId = Long.valueOf(scanner.nextLine());
                    library.getRentedBooks(rentedBooksMemberId);
                    break;
                case 0:
                    System.out.println("See you soon!");
                    showMenuAgain = false;
                    break;
            }

        } while (showMenuAgain);

    }
}