package base;

import enums.*;
import interfaces.*;
import item.*;
import humanPart.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Human implements Drive, Changeable{
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
    protected double[] conditions = new double[Condition.values().length];
    {for (int i = 0; i<Condition.values().length;i++){
      this.conditions[i] = 60;
    }}
    public Head head = new Head("голова", this);
    public Hair hair = new Hair("волосы", this);
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
    public String getName(){
        return name;
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
            this.head.getEyes().act(this);
            this.setCondition(Condition.COMFORT, -5);
        }
        if (item.getClass()==Car.class){
            if (((Car) item).getHeadlights()){
                this.setTypes(HumanType.BLINDED, HumanType.CONFUSED);
                this.head.getEyes().act(this);
                this.setCondition(Condition.COMFORT, -9);
                this.head.getEyes().setClarity(-0.02);
            }
        }
    }
    public void look(Location location) {
        lookHuman = null;
        lookItem = null;
        lookLocation = location;
        System.out.print(this + " оглядывал " + location +". Здесь было  " );
        System.out.println(Arrays.toString(location.getTypes()));
        if (location.hasType(ItemType.BURIAL)){
            this.setCondition(Condition.FUN, -5);
        }
    }
    public void askedRead(Human human, Book book){
        System.out.println("по просьбе "+ this);
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
            this.setCondition(Condition.SATISFACTION,-13);
            human.setCondition(Condition.SATISFACTION,-13);
        }
    }
    public void say(String speech){
        System.out.println(this + " сказал" + speech);
        if (this.occupation==Occupation.DIR_FUNERAL_HOME){
            for (Human human : getLocation().getPeople()){
                human.setCondition(Condition.FUN,-2);
            }
        }
    }
    public void seem(){
        if (this.lookHuman.head.getFace().hasType(BodyType.BRISTLE)){
            System.out.println(this +" казалось, что " + this.lookHuman + " выглядит ещё старше");
        }
        if (this.lookHuman.hasType(HumanType.CONFUSED)){
            System.out.println(this+ " казалось, что "+ this.lookHuman + " просто не соображал, что происходит");
            lookHuman.setCondition(Condition.COLLECT, -6);
        }
    }
    public void tryToPity(){
        if (Math.random() < 0.8d){
            System.out.println(this+" пытался сжалиться над " + this.lookHuman + "ом, но у него не получилось");
            this.setTypes(HumanType.INSENSITIVE);
            this.setCondition(Condition.DILIGENCE, -3);
        } else{
            System.out.println(this+ "у стало жалко "+ this.lookHuman);
            this.setTypes(HumanType.COMPASSIONATE);
            this.setCondition(Condition.DILIGENCE, 4);
        }
    }
    public void tryToProtest(){
        if (Math.random() < 0.7d){
            System.out.println(this+" пыталась протестовать, но " +this.lookHuman + " был твёрд");
            this.lookHuman.setTypes(HumanType.PERSISTENT);
            this.setCondition(Condition.DILIGENCE, -6);
        } else{
            System.out.println(this+ " пыталась протестовать и смогла убедить "+ this.lookHuman);
            this.lookHuman.setTypes(HumanType.COMPLIANT);
            this.setCondition(Condition.DILIGENCE, 10);
        }
    }
    public void understand(){
        if (Math.random() < 0.8d){
            System.out.println(this + " понял, что это такое");
            if (this.getName() == "Луис"){
                this.removeType(HumanType.BLINDED, HumanType.CONFUSED);
            }
        } else{
            System.out.println(this + " не понял, что  это такое");
        }
    }
    public void startCar(Car car){
        System.out.println(car.getDriver() + " завёл машину");
        car.started();
    }
    public void smoke(){
        Cigarette cigarette = new Cigarette(true);
        System.out.println(this + " решил покурить");
        cigarette.action(this);
        this.setCondition(Condition.HEALTH, -0.3);
    }
    public void putInCar(Item item,Car car ){
        System.out.println(this + " положил " + item + " в машину");
        car.setItems(item);
    }
    public void drive(Car car){
        System.out.println(this + " нажал на газ");
        car.start();
    }
    public void takeBodyPart(BodyPart part){
        this.hands.take(part);
        part.getOwner().lookHuman = this;
    }
    public void bowHead(){
        this.head.act(this);
    }
    public void setCondition(Condition condition, double var){
        switch (condition){
            case COMFORT:
                this.conditions[Condition.COMFORT.ordinal()] +=var;
                break;
            case SATISFACTION:
                this.conditions[Condition.SATISFACTION.ordinal()] +=var;
                break;
            case HEALTH:
                this.conditions[Condition.HEALTH.ordinal()] +=var;
                break;
            case DILIGENCE:
                this.conditions[Condition.DILIGENCE.ordinal()] +=var;
                break;
            case FUN:
                this.conditions[Condition.FUN.ordinal()] +=var;
                break;
            case COLLECT:
                this.conditions[Condition.COLLECT.ordinal()] +=var;
                break;
        }
    }
    public double getCondition(Condition cond){
        return this.conditions[cond.ordinal()];
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return name.equals(human.name);
    }
    public int hashCode(){
        return Objects.hash(name, occupation);
    }
}
