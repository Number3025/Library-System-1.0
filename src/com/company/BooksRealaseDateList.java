package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class BooksRealaseDateList {
    public static ArrayList<Book> notrealisedbookList = new ArrayList<>();
    SortBookTitle sortBookTitle = new
            SortBookTitle();
    public void AddBooksToList() {
        notrealisedbookList.add(new Book("The Doors of Stone", "08-2020", "0575081449", "Patrick Rothfuss",896));
        notrealisedbookList.add(new Book("Overlord volume 14", "03-2020", "9784047358850", "Kugane Maruyama", 576));
        notrealisedbookList.add(new Book("The Ballad of Songbirds and Snakes", "05-2020", "1338635174", "Suzanne Collins",540 ));
        Collections.sort(notrealisedbookList, sortBookTitle);
    }




    public static ArrayList<Book> getNotRealisedBookList() {
        return notrealisedbookList;
    }
}
