package item;

import base.Human;
import base.Item;
import enums.Color;

public class Corpse extends Item {
    private String name = "мертвец";
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
