package Base;

import Enums.BodyType;
import Enums.Color;
import Enums.ItemType;
import Interface.Drive;
import Item.*;
import HumanPart.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Human implements Drive {
    protected Occupation occupation;
    protected String name;
    protected Position position;
    protected Location location;
    protected ArrayList<HumanType> humanTypes = new ArrayList<>();
    protected ArrayList<Human> foe = new ArrayList<>();
    protected ArrayList<Item> things = new ArrayList<>();
    protected Human lookHuman;
    protected Item lookItem;
    protected Location lookLocation;
    public Head head = new Head("голова", this);
    public Face face = new Face("лицо", this);
    public Hair hair = new Hair("волосы", this);
    public Eyes eyes = new Eyes("глаза", this);
    public Hands hands = new Hands("руки", this);
    public Human(Occupation occupation){
        this.occupation = occupation;
    }
    public Human(String name,Occupation occupation){
        this.name = name;
        this.occupation = occupation;
    }
    public Human(String name){
        this.name = name;
    }
    public void setLocation(Location location) {
        this.location = location;
        location.addHuman(this);
    }
    public Location getLocation() {
        return location;
    }
    public void setTypes(HumanType... humanTypes) {
        this.humanTypes.addAll(Arrays.asList(humanTypes));
    }
    public void setThings(Item... thing){
        this.things.addAll(Arrays.asList(thing));
        //System.out.println(this+" получил" + Arrays.toString(thing));
    }
    public Item[] getThings() {
        Item[] things1 = new Item[this.things.size()];
        return this.things.toArray(things1);
    }

    public boolean hasType(HumanType humanType) {
        return humanTypes.contains(humanType);
    }
    public void removeType(HumanType... humanType) {
        for (HumanType type : humanType) {
            this.humanTypes.remove(type);
        }
    }
    public void read(Book fragment){
        System.out.println(this.occupation + "прочитал" + fragment);
    }
    public void stand(Position position){
        position.addPosition(this);
        System.out.println(this + " стоял на " + position);
        if (this.hands.hold!=null){
            System.out.println("и "+ hands.hold + " вместе с ним");
            position.addPosition(hands.hold);
        }
    }
    public void look(Human human) {
        lookHuman = human;
        lookItem = null;
        lookLocation = null;
        if (this.hasType(HumanType.EMBARRASED)){
        System.out.println(this + " оглянулся на " + human+ " и быстро отвёл глаза");
        lookHuman = null;
    } else {
            System.out.println(this + " посмотрел на " + human);
        }
    }
    public void look(Item item) {
        lookHuman = null;
        lookItem = item;
        lookLocation = null;
        System.out.println(this + " посмотрел на " + item );
        if (item.getColor() == Color.BRIGHT_GREEN){
            this.eyes.act(this);
        }
        if (item.hasType(ItemType.BRIGHT)){
            this.setTypes(HumanType.BLINDED);
            this.eyes.act(this);
        }
    }
    public void look(Location location) {
        lookHuman = null;
        lookItem = null;
        lookLocation = location;
        System.out.print(this + " оглядывал " + location +". Здесь было  " );
        System.out.println(Arrays.toString(location.getTypes()));
    }
    public void askedRead(Human human, Book book){
        System.out.println("по просьбе "+this);
        human.read(book);
    }

    protected void addPos(Position position){
        this.position = position;
    }
    public void argue(Human human){
        if (this.getLocation().hasType(ItemType.QUIETLY)){
            System.out.println(this + " не поссорился с " + human + ", т.к на " + getLocation() + " должно быть тихо");
        } else {
            System.out.println(this+" поссорился с  " + human);
            this.foe.add(human);
            human.foe.add(this);
        }
    }
    public void say(String speech){
        System.out.println(this + " сказал" + speech);
    }
    public void seem(){
        if (this.lookHuman.face.hasType(BodyType.BRISTLE)){
            System.out.println(this +" казалось, что " + this.lookHuman + " выглядит ещё старше");
        }
        if (this.lookHuman.hasType(HumanType.CONFUSED)){
            System.out.println(this+ " казалось, что "+ this.lookHuman + " просто не соображал, что происходит");
        }
    }
    public void tryToPity(){
        if (Math.random() < 0.8d){
            System.out.println(this+" пытался сжалиться над " +this.lookHuman + "ом, но у него не получилось");
            this.setTypes(HumanType.INSENSITIVE);
        } else{
            System.out.println(this+ "у стало жалко "+ this.lookHuman);
            this.setTypes(HumanType.COMPASSIONATE);
        }
    }
    public void tryToProtest(){
        if (Math.random() < 0.7d){
            System.out.println(this+" пыталась протестовать, но " +this.lookHuman + " был твёрд");
            this.lookHuman.setTypes(HumanType.PERSISTENT);
            this.setTypes(HumanType.UNHAPPY);
        } else{
            System.out.println(this+ " пыталась протестовать и смогла убедить "+ this.lookHuman);
            this.lookHuman.setTypes(HumanType.COMPLIANT);
        }
    }

    public void understand(){
        if (Math.random() < 0.8d){
            System.out.println(this+" понял, что это такое");
            this.removeType(HumanType.BLINDED);
        } else{
            System.out.println(this+" не понял, что  это такое");
        }
    }
    public void startCar(Car car){
        System.out.println(car.getDriver() +" завёл машину");
        car.started();
    }
    public void smoke(){
        Cigarette cigarette = new Cigarette(true);
        System.out.println(this+" решил покурить");
        cigarette.action(this);
    }
    public void putInCar(Item item,Car car ){
        System.out.println(this + " положил "+ item+ " в машину");
        car.setItems(item);
    }
    public void drive(Car car){
        System.out.println(this+" нажал на газ");
        car.start();
    }
    public void takeBodyPart(BodyPart part){
        this.hands.take(part);
        part.getOwner().lookHuman = this;
    }
    public void bowHead(){
        this.head.act(this);
    }
    @Override
    public String toString() {
        return name;
    }
}
