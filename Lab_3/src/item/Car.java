package item;

import base.Human;
import base.Item;
import base.Position;
import enums.Color;
import enums.ItemType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Car extends Item implements Position{
    private String name;
    private Human driver = null;
    private boolean headlights = false;
    private int speed = 0;
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
    public boolean getHeadlights(){
        return headlights;
    }
    public Item[] getItems() {
        Item[] trunk1 = new Item[this.trunk.size()];
        return this.trunk.toArray(trunk1);
    }
    public void started(){
        this.headlights = true;
        System.out.println(name+" завёлся. Фары загорелись");
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
        this.speed = (int) (Math.random() * 120);
        System.out.println(name+ " пришёл в движение. Скорость грузовика: " + speed);
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
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return getDriver().getName().equals(car.getDriver().getName());
    }
    public int hashCode(){
        return Objects.hash(name);
    }
}

