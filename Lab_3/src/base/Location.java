package base;

import java.util.ArrayList;
import java.util.Arrays;
import enums.ItemType;

public class Location {
    private String name;
    private ArrayList<Human> people = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<ItemType> locType = new ArrayList<>();
    public Location(String name, ItemType... locType){
        this.name = name;
        setTypes(locType);
    }
    public void setTypes(ItemType... locTypes) {
        this.locType.addAll(Arrays.asList(locTypes));
    }
    public ItemType[] getTypes() {
        ItemType[] locType1 = new ItemType[this.locType.size()];
        return this.locType.toArray(locType1);
    }
    public boolean hasType(ItemType locType) {
        return this.locType.contains(locType);
    }
    public void setPeople(Human... people) {
        this.people.addAll(Arrays.asList(people));
        for (Human human : people) {
            human.setLocation(this);
        }
    }
    public Human[] getPeople() {
        Human[] people = new Human[this.people.size()];
        return this.people.toArray(people);
    }
    public void removePeople(Human... people) {
        for (Human human : people) {
            this.people.remove(human);
        }
    }
    protected void addHuman(Human human){
        this.people.add(human);
    }
    protected void addItem(Item item){
        this.items.add(item);
    }
    public void setItems(Item... items) {
        this.items.addAll(Arrays.asList(items));
        for (Item item : items) {
            item.setLocation(this);
        }
    }
//    public Item[] getItems() {
//        Item[] items = new Item[this.items.size()];
//        return this.items.toArray(items);
//    }
//    public void removeItems(Item... items) {
//        for(Item item : items){
//            this.items.remove(item);
//        }
//    }
    @Override
    public String toString() {
        return name;
    }
}
