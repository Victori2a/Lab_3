package enums;

public enum Condition {
    COMFORT("комфорт"),
    HEALTH("здоровье"),
    SATISFACTION("удовлетворённость"),
    DILIGENCE("старательность"),
    COLLECT("собранность"),
    FUN("радость");
    String name;
    Condition(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name;
    }
}
