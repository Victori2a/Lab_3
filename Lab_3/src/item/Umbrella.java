package item;

import base.Human;
import base.Item;
import enums.Color;
import enums.ItemType;
import java.util.Arrays;

public class Umbrella extends Item {
    public String name = "зонт";
    private Color color;
    public Umbrella(Color color, ItemType... types){
        this.color = color;
        this.types.addAll(Arrays.asList(types));
    }
    @Override
    public void action(Human human) {
    }

    @Override
    public Color getColor() {
        return color;
    }
    public String toString(){
        return name;
    }
}

