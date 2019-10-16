package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class LibrarySystem {


    public static ArrayList<AudioBook> audiobooks = new ArrayList<>();
    static SortAudioBookTitle sortAudioBookTitle = new
            SortAudioBookTitle();
    static SortAudioBookAuthors sortAudioBookAuthors = new
            SortAudioBookAuthors();

    public static ArrayList<Book> books = new ArrayList<>();
    static SortBookTitle sortBookTitle = new
            SortBookTitle();
    static SortBookAuthors sortBookAuthors = new
            SortBookAuthors();

    static String[] helps = {"Please Choose one option", "If you want to add a book press 1", "If you want to add a Audiobook press 2", "If you want to see all books Currently in press 3", "If you want to see all Audiobooks Currently in press 4", "if you want to remove a book or audiobook press 6", "if Want to sort the books in specific way press 7", "if Want to sort the audibooks in specific way press 8","if you want to save all books into the SaveData Press 9","if you want to save all audiobooks into the SaveData Press 10", "If you want to Load the Savedata for all Books press 11", "If you want to Load the Savedata for all audioBooks press 12", "To Exit the program press 13"};


    private String nameOfSchool = "";

    public LibrarySystem(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
        audiobooks.add(new AudioBook("Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future  ", "2015-03-3 ", "0062301233 ", "Ashlee Vance"));
        audiobooks.add(new AudioBook("Never Split the Difference: Negotiating As If Your Life Depended On It ", "2016-05-17 ", "0062407805 ", "Chris Voss"));
        Collections.sort(audiobooks, sortAudioBookTitle);
        books.add(new Book("Deep Work ", "2016-01-05 ", "1455586692 ", "Cal Newport "));
        books.add(new Book("The Happiness equation ", "2015-03-31 ", "0399169474 ", "Nail Pasricha "));
        books.add(new Book("The Name of the wind ", "2007-03-27 ", "075640407 ", "Patrick Rothfuss "));
        Collections.sort(books, sortBookTitle);

    }

    public static ArrayList<Book> readObjects(ArrayList<Book> fileName) {
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

    public static ArrayList<AudioBook> readObjectss(ArrayList<AudioBook> audiobooks) {
        ObjectInputStream objectinputstream = null;
        ArrayList<AudioBook> list  = null;
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


    public static void writeObjects(ArrayList<Book> books) {

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

    public static void writeObjectss(ArrayList<AudioBook> audioBooks) {

        ObjectOutputStream objectOutputStream = null;

        FileOutputStream fileOutputStream = null;

        try {

            fileOutputStream = new FileOutputStream("AudioBookList.ser", false);

            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(audioBooks);

            objectOutputStream.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    public static void showMainMenu(String nameOfLibrary) {
        System.out.println("welcome to " + nameOfLibrary);
        Scanner scanner = new Scanner(System.in);
        boolean continuetoorun = true;
        while (continuetoorun) {

            System.out.println("What would it be Today?:"

                    + "\n1: Add Book"

                    + "\n2: Add Audio Book"

                    + "\n3: Show Books in store"

                    + "\n4: Show Audio Books in store"

                    + "\n5: Help"

                    + "\n6: Go to Submenu "

                    + "\n7: Sort Books "

                    + "\n8: Sort AudioBooks "

                    + "\n9: Save Booklist "

                    + "\n10: Save AudioBooklist "

                    + "\n11: Read Booklist "

                    + "\n12: Read AudioBooklist "

                    + "\n13: Exit Program");

            String userChoice = scanner.nextLine();

            switch (userChoice) {


                case "1":
                    System.out.println("Please Enter Name,Date,Id and Author for Book");
                    Scanner scanners = new Scanner(System.in);
                    String bookName = scanners.nextLine();
                    String bookDate = scanners.nextLine();
                    String bookId = scanners.nextLine();
                    String bookAuthor = scanners.nextLine();
                    LibrarySystem.books.add(new Book(bookName, bookDate, bookId, bookAuthor));
                    Collections.sort(books, sortBookTitle);
                    break;

                case "2":
                    System.out.println("Please Enter Name,Date,Id and Author for AudioBook ");
                    Scanner scannert = new Scanner(System.in);
                    String audioBookName = scannert.nextLine();
                    String audioBookDate = scannert.nextLine();
                    String audiobookId = scannert.nextLine();
                    String audiobookAuthor = scannert.nextLine();
                    LibrarySystem.audiobooks.add(new AudioBook(audioBookName, audioBookDate, audiobookId, audiobookAuthor));
                    Collections.sort(audiobooks, sortAudioBookTitle);
                    break;


                case "3":
                    for (Book book : books) {
                        System.out.println(book.title + book.date + book.id + book.author);
                    }
                    break;


                case "4":
                    for (AudioBook audioBook : audiobooks) {
                        System.out.println(audioBook.title + audioBook.date + audioBook.id + audioBook.author);
                    }
                    break;


                case "5":
                    for (String s : helps) {
                        System.out.println(s);
                    }
                    break;

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
                                for (Book book : books) {
                                    System.out.println(book.title + book.date + book.id + book.author);
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
                                for (AudioBook audioBook : audiobooks) {
                                    System.out.println(audioBook.title + audioBook.date + audioBook.id + audioBook.author);
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
                    System.out.println("Exiting Program");
                    continuetoorun = false;

                    break;


                default:

                    System.out.println("Wrong input");


            }
        }

    }


}
