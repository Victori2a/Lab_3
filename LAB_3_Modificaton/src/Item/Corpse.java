package Item;

import Base.Human;
import Base.Item;
import Enums.Color;

public class Corpse extends Item {
    private final String name = "мертвец";
    private String corpseName;
    public Corpse(String corpseName){
        this.corpseName = corpseName;
    }
    @Override
    public void action(Human human) {

    }
    public Color getColor() {
        return null;
    }
    public String toString() {
        return corpseName;
    }
}
