package com.company;

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
    static String[] helps = {"Please Choose one option", "If you want to add a book press 1", "If you want to add a Audiobook press 2", "If you want to see all books Currently in press 3", "If you want to see all Audiobooks Currently in press 4", "To Exit the program press 6"};


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

                    + "\n10: save AudioBooklist "

                    + "\n11: read Booklist "

                    + "\n12: read AudioBooklist "

                    + "\n13: Exit Program");

            String userChoice = scanner.nextLine();

            switch (userChoice) {


                case "1":
                    System.out.println("Please Enter Name,Date and Id for Book");
                    Scanner scanners = new Scanner(System.in);
                    String bookName = scanners.nextLine();
                    String bookDate = scanners.nextLine();
                    String bookId = scanners.nextLine();
                    String bookAuthor = scanners.nextLine();
                    LibrarySystem.books.add(new Book(bookName, bookDate, bookId, bookAuthor));
                    Collections.sort(books, sortBookTitle);
                    break;

                case "2":
                    System.out.println("Please Enter Name,Date and Id for AudioBook ");
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
                    //Write some lines to a
                    List<String> lines = new ArrayList<>();
                    for (Book book : books) {
                        lines.add(book.title + book.date + book.id + book.author);


                        try {
                            Path path = Paths.get("./Booklist");
                            Files.write(path, lines, StandardCharsets.UTF_8);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case "10":
                    //Write some lines to a file
                    List<String> linesss = new ArrayList<>();
                    for (AudioBook audioBook : audiobooks) {
                        linesss.add(audioBook.title + audioBook.date + audioBook.id + audioBook.author);


                        try {
                            Path path = Paths.get("./AudioBookList");
                            Files.write(path, linesss, StandardCharsets.UTF_8);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;


                case "11":


                    String bookListName = "BookList";

                    try {

                        List<String> liness = Files.readAllLines(Paths.get(bookListName));

                        for (String line : liness) {

                            System.out.println(line);

                        }

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                    break;
                case "12":

                    String audioBookListname = "AudioBookList";

                    try {

                        List<String> liness = Files.readAllLines(Paths.get(audioBookListname));

                        for (String line : liness) {

                            System.out.println(line);

                        }

                    } catch (Exception e) {

                        e.printStackTrace();

                    }
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
