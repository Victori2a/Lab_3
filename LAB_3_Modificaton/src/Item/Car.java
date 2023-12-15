package Item;

import Base.Human;
import Base.Item;
import Base.Position;
import Enums.Color;
import Enums.ItemType;

import java.util.ArrayList;
import java.util.Arrays;

public class Car extends Item implements Position{
    private String name;
    private Human driver = null;
    private boolean headlights = false;
    private boolean isRide = false;
    private ArrayList<Item> trunk = new ArrayList<>();
    public Car(String name, Human driver){
        this.driver = driver;
        this.name = name;
    }
    public Car(String name){
        this.name = name;
    }
    public void setItems(Item... items) {
        this.trunk.addAll(Arrays.asList(items));
    }
    public Item[] getItems() {
        Item[] trunk1 = new Item[this.trunk.size()];
        return this.trunk.toArray(trunk1);
    }
    public void started(){
        System.out.println(name+" завёлся");
        this.headlights = true;
        this.setType(ItemType.BRIGHT);
    }
    public void stand(Position position){
        position.addPosition(this);
        if (this.hasType(ItemType.INCONSPICUOUS)) {
            System.out.println(this + " стоит за " + position + ", где его никто не видит");
        }
    }
    public Human getDriver(){
        return driver;
    }
    public void start(){
        this.isRide = true;
        System.out.println(name+ " пришёл в движение");
    }
    @Override
    public void action(Human human) {

    }
    public Color getColor() {
        return null;
    }
    public String toString(){
        return name;
    }
}
