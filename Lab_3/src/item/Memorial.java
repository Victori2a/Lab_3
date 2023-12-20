package item;

import base.Human;
import base.Item;
import base.Position;
import enums.Color;
import enums.ItemType;

public class Memorial extends Item implements Position {
    String surname;
    private String name = "памятник";

    public Memorial(String surname, ItemType... type){
        this.surname = surname;
        setType(type);
    }

    @Override
    public void action(Human human) {

    }
    public Color getColor() {
        return null;
    }

    public String toString() {
        return name+" c фамилией "+surname;
    }
}
