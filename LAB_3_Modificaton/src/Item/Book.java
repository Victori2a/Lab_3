package Item;

import Base.Human;
import Base.Item;
import Enums.Color;


public class Book extends Item {
    protected String nameOfBook;
    public Book(String nameOfBook){
        this.nameOfBook = nameOfBook;
    }
    Book(){}

    @Override
    public void action(Human human) {

    }
    public Color getColor() {
        return null;
    }
}
