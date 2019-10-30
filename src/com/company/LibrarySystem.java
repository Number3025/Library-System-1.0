package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * LibrarySystem this the class that runs the LibrarySystem
 */
public class LibrarySystem {
    public ArrayList<Book> notrealisedbookList = BooksRealaseDateList.getNotRealisedBookList();
    /**
     * This is List of the books in the library it can be sorted alphabetical in either book name or author name
     */
    public static ArrayList<AudioBook> audiobooks = new ArrayList<>();


    SortAudioBookTitle sortAudioBookTitle = new
            SortAudioBookTitle();
    SortAudioBookAuthors sortAudioBookAuthors = new
            SortAudioBookAuthors();
    /**
     * This is List of the Audiobooks in the library it can be sorted alphabetical in either book name or author name
     */
    public static ArrayList<Book> books = new ArrayList<>();


    SortBookTitle sortBookTitle = new
            SortBookTitle();
    SortBookAuthors sortBookAuthors = new
            SortBookAuthors();
    /**
     * A help menu for understanding the menu options better
     */
    String[] helps = {"Please Choose one option", "If you want to add a book press 1", "If you want to add a Audiobook press 2", "If you want to see all books Currently in press 3", "If you want to see all Audiobooks Currently in press 4", "if you want to remove a book or audiobook press 6", "if Want to sort the books in specific way press 7", "if Want to sort the audibooks in specific way press 8", "if you want to save all books into the SaveData Press 9", "if you want to save all audiobooks into the SaveData Press 10", "If you want to Load the Savedata for all Books press 11", "If you want to Load the Savedata for all audioBooks press 12", "To Exit the program press 13"};


    private String nameOfSchool = "";

    /**
     * @param nameOfSchool The name of the Library is given here
     */
    public LibrarySystem(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
        audiobooks.add(new AudioBook("Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future", "2015-03-3", "0062301233", "Ashlee Vance", 803));
        audiobooks.add(new AudioBook("Never Split the Difference: Negotiating As If Your Life Depended On It", "2016-05-17", "0062407805", "Chris Voss", 487));
        Collections.sort(audiobooks, sortAudioBookTitle);
        books.add(new Book("Deep Work", "2016-01-05", "1455586692", "Cal Newport", 304));
        books.add(new Book("The Happiness equation", "2015-03-31", "0399169474", "Nail Pasricha", 320));
        books.add(new Book("The Name of the wind", "2007-03-27", "075640407", "Patrick Rothfuss", 662));
        Collections.sort(books, sortBookTitle);

    }

    /**
     * @return Returns the books that have been taken from the online Booklist
     */
    public ArrayList<Book> readObjects(ArrayList<Book> fileName) {
        ObjectInputStream objectinputstream = null;
        ArrayList<Book> list = null;
        try {
            FileInputStream streamIn = new FileInputStream("BookList.ser");
            objectinputstream = new ObjectInputStream(streamIn);
            books = (ArrayList<Book>) objectinputstream.readObject();
            objectinputstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    /**
     * @return Returns the Audiobooks that have been taken from the online AudioBooklist
     */
    public ArrayList<AudioBook> readObjectss(ArrayList<AudioBook> audiobooks) {
        ObjectInputStream objectinputstream = null;
        ArrayList<AudioBook> list = null;
        try {
            FileInputStream streamIn = new FileInputStream("AudioBookList.ser");
            objectinputstream = new ObjectInputStream(streamIn);
            audiobooks = (ArrayList<AudioBook>) objectinputstream.readObject();
            objectinputstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return audiobooks;
    }

    /**
     * method writes all books in arraylist to Booklist.ser file
     */
    public void writeObjects(ArrayList<Book> books) {

        ObjectOutputStream objectOutputStream = null;

        FileOutputStream fileOutputStream = null;

        try {

            fileOutputStream = new FileOutputStream("BookList.ser", false);

            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(books);

            objectOutputStream.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    /**
     * @param audiobooks A method writes all Audiobooks in arraylist to AudioBooklist.ser file
     */
    public void writeObjectss(ArrayList<AudioBook> audiobooks) {

        ObjectOutputStream objectOutputStream = null;

        FileOutputStream fileOutputStream = null;

        try {

            fileOutputStream = new FileOutputStream("AudioBookList.ser", false);

            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(audiobooks);

            objectOutputStream.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static ArrayList<AudioBook> getAudiobooks() {
        return audiobooks;
    }

    /**
     * @param nameOfLibrary a method that works by getting variable name from the main class
     */
    public void showMainMenu(String nameOfLibrary) {
        System.out.println("welcome to " + nameOfLibrary);
        Scanner scanner = new Scanner(System.in);
        boolean continuetoorun = true;
        while (continuetoorun) {
/**
 * Creates a menu of options
 */
            System.out.println("What would it be Today?:"

                    + "\n1: Add Book"

                    + "\n2: Add Audio Book"

                    + "\n3: Show Books in store"

                    + "\n4: Show Audio Books in store"

                    + "\n5: Show Books Not realesed yet "

                    + "\n6: Go to Submenu "

                    + "\n7: Sort Books "

                    + "\n8: Sort AudioBooks "

                    + "\n9: Save Booklist "

                    + "\n10: Save AudioBooklist "

                    + "\n11: Read Booklist "

                    + "\n12: Read AudioBooklist "

                    + "\n13: Help"

                    + "\n14: Exit Program");

            String userChoice = scanner.nextLine();

            switch (userChoice) {

/**
 * Adds a new book to the arraylist
 */
                case "1":
                    System.out.println("Please Enter Name");
                    Scanner scanners = new Scanner(System.in);
                    String bookName = scanners.nextLine();
                    System.out.println("Please Enter Date");
                    String bookDate = scanners.nextLine();
                    System.out.println("Please Enter Id");
                    String bookId = scanners.nextLine();
                    System.out.println("Please Enter Author");
                    String bookAuthor = scanners.nextLine();
                    System.out.println("Please Enter Number of Pages");
                    int bookPages = scanners.nextInt();
                    LibrarySystem.books.add(new Book(bookName, bookDate, bookId, bookAuthor, bookPages));
                    Collections.sort(books, sortBookTitle);
                    break;
/**
 * Adds a new Audiobook to the arraylist
 */
                case "2":
                    System.out.println("Please Enter Name");
                    Scanner scannert = new Scanner(System.in);
                    String audioBookName = scannert.nextLine();
                    System.out.println("Please Enter Date");
                    String audioBookDate = scannert.nextLine();
                    System.out.println("Please Enter Id");
                    String audiobookId = scannert.nextLine();
                    System.out.println("Please Enter Author");
                    String audiobookAuthor = scannert.nextLine();
                    System.out.println("Please Enter Length");
                    float length = scannert.nextFloat();
                    LibrarySystem.audiobooks.add(new AudioBook(audioBookName, audioBookDate, audiobookId, audiobookAuthor, length));
                    Collections.sort(audiobooks, sortAudioBookTitle);
                    break;

/**
 * Shows all Book objects in the arraylist
 */
                case "3":
                    Book book = new Book("", "", "", "", 1);
                    book.PrintInfo();
                    //System.out.println("Title: " + book.getTitle() + " " + "Date: " + book.getDate() + " " + "Id: " + book.getId() + " " + "Author: " + book.getAuthor() + " " + "Pages: " + book.getNumberOfpages());

                    break;

/**
 * shows all AudioBooks in the arraylist
 */
                case "4":
                    AudioBook audioBook = new AudioBook("", "", "", "", 1);
                    audioBook.PrintInfo();
                    //System.out.println("Title: " + audioBook.getTitle() + " " + "Date: " + audioBook.getDate() + " " + "Id: " + audioBook.getId() + " " + "Author: " + audioBook.getAuthor() + " " + "Minutes: " + audioBook.getLengthMinutes());

                    break;
                case "5":
                    for (Book book1 : notrealisedbookList) {
                        System.out.println("Title: " + book1.getTitle() + " " + "Date: " + book1.getDate() + " " + "Id: " + book1.getId() + " " + "Author: " + book1.getAuthor() + " " + "Pages: " + book1.getNumberOfpages());
                    }
                    break;
/**
 * explains all the menu options
 */


                case "6":

                    System.out.println("What would it be Today?:"

                            + "\n1: Remove Book"

                            + "\n2: remove Audio Book");

                    int remover = scanner.nextInt();

                    switch (remover) {


                        case 1:
                            if (books.isEmpty()) { //kollar om arraylist är tom
                                System.out.println("List is empty");
                                continuetoorun = false;
                                break;
                            } else {
                                System.out.println("please choice which book to remove");
                                for (Book book2 : books) {
                                    System.out.println("Title: " + book2.getTitle() + " " + "Date: " + book2.getDate() + " " + "Id: " + book2.getId() + " " + "Author: " + book2.getAuthor() + " " + "Pages: " + book2.getNumberOfpages());
                                }
                                Scanner bookRe = new Scanner(System.in);
                                int bookre = scanner.nextInt();
                                books.remove(bookre - 1); //användaren vet inte att index börjar på noll så jag korrekterar detta
                            }
                            break;

                        case 2:
                            if (audiobooks.isEmpty()) {
                                System.out.println("List is empty");
                                continuetoorun = false;
                                break;
                            } else {
                                System.out.println("please choice which Audiobook to remove");
                                for (AudioBook audioBook1 : audiobooks) {
                                    System.out.println("Title: " + audioBook1.getTitle() + " " + "Date: " + audioBook1.getDate() + " " + "Id: " + audioBook1.getId() + " " + "Author: " + audioBook1.getAuthor() + " " + "Minutes: " + audioBook1.getLengthMinutes());
                                }
                                Scanner audioBookRe = new Scanner(System.in);
                                int audioBookre = scanner.nextInt();
                                audiobooks.remove(audioBookre - 1);
                            }
                            break;


                        default:
                            System.out.println("Wrong input");


                    }


                    break;


                case "7":
                    System.out.println("What would it be Today?:"

                            + "\n1: Sort by Author"

                            + "\n2: Sort by Title");
                    String sorter = scanner.nextLine();

                    switch (sorter) {
                        case "1":
                            Collections.sort(books, sortBookAuthors);
                        case "2":
                            Collections.sort(books, sortBookTitle);
                    }
                    break;


                case "8":
                    System.out.println("What would it be Today?:"

                            + "\n1: Sort by Author"

                            + "\n2: Sort by Title");
                    String asorter = scanner.nextLine();

                    switch (asorter) {
                        case "1":
                            Collections.sort(audiobooks, sortAudioBookAuthors);
                        case "2":
                            Collections.sort(audiobooks, sortAudioBookTitle);
                    }
                    break;

                case "9":
                    writeObjects(books);
                    break;

                case "10":
                    writeObjectss(audiobooks);
                    break;


                case "11":
                    readObjects(books);
                    break;
                case "12":
                    readObjectss(audiobooks);
                    break;
                case "13":
                    for (String s : helps) {
                        System.out.println(s);
                    }
                    break;

                case "14":
                    System.out.println("Exiting Program");
                    continuetoorun = false;

                    break;


                default:

                    System.out.println("Wrong input");


            }
        }

    }


}
