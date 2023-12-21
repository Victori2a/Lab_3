package item;

import base.Human;
import base.Item;
import enums.Color;


public class Book extends Item {
    protected String nameOfBook;
    public Book(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    Book() {
    }
}
