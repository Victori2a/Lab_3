package Item;

import Base.Human;
import Base.Item;
import Enums.Color;
import Enums.ItemType;

public class Coffin extends Item {
    private static final String name = "гроб";
    private Corpse owner;
    private Color color = null;
    private Grave grave;
    private boolean lock;
    public Coffin( Corpse owner, Color color, Grave grave, boolean lock){
        this.color=color;
        this.grave = grave;
        this. owner=owner;
        this.lock = lock;
    }

    public Corpse getOwner(){
        return this.owner;
    }

    @Override
    public void action(Human human) {

    }
    public void stand(){
        if (this.getColor()==Color.WHITE ) {
            System.out.println(getColor()+" " + this +" " + this.getOwner()+ "а стоял над прокладкой на двух хромированных подставках");
        } else{
            super.stand();
        }
    }
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name;
    }
}
