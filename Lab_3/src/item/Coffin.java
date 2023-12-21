package item;

import base.Human;
import base.Item;
import enums.Color;
import enums.ItemType;

public class Coffin extends Item {
    private String name = "гроб";
    private Corpse owner;
    private Color color = null;
    private Grave grave;
    private boolean lock;
    public Coffin( Corpse owner, Color color, Grave grave, boolean lock){
        this.color=color;
        this.grave = grave;
        this. owner=owner;
        this.lock = lock;
        if (lock){
            this.setType(ItemType.REPAIRED_LOCKS);
        }
    }

    public Corpse getOwner(){
        return this.owner;
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
