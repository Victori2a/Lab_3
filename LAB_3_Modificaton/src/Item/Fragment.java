package Item;

import Item.Book;

public class Fragment extends Book {
    String start;
    Book book;
    public Fragment(Book book, String start) {
        super();
        this.book = book;
        this.start = start;
    }
    @Override
    public String toString() {
        return " отрывок из "+book.nameOfBook+", начинающийся со слов "+start;
    }
}
