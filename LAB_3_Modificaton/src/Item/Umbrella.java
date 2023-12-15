package Item;

import Base.Human;
import Base.Item;
import Enums.Color;

public class Umbrella extends Item {
    public final String name = "зонт";
    private Color color;
    public Umbrella(Color color){
        this.color = color;
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
