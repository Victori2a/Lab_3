package Item;

import Base.Human;
import Base.Item;
import Base.Position;
import Enums.Color;
import Enums.ItemType;

public class Memorial extends Item implements Position {
    String surname;
    private final String name = "памятник";

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
