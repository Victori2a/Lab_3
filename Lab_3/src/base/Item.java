package base;

import enums.Color;
import enums.ItemType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Item {
    protected String name;
    protected Location location;
    protected Position position;
    protected ArrayList<ItemType> types = new ArrayList<>();
    public Color getColor() {
        return null;
    }
    public void setType(ItemType... types) {
        this.types.addAll(Arrays.asList(types));
    }
    public boolean hasType(ItemType type) {
        return this.types.contains(type);
    }
    public Location getLocation() {
        return this.location;
    }
    public void setLocation(Location location) {
        location.addItem(this);
        this.location = location;
    }
    protected void addPos(Position position){
        this.position = position;
    }
    public void stand(Position position){
        position.addPosition(this);
        //System.out.println(this + " стоит на " + position);
    }
    public Position getPosition(){
        return position;
    }
    public void stand(){
        System.out.println(this +" где-то стоит");
    }
}
