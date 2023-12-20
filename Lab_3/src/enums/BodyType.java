package enums;

public enum BodyType {
    EYES_BAG("мешки под глазами"),
    BRISTLE("щетина на щеках"),
    THIN("редкие"),
    GRAY("седые");
    String name;
    BodyType(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}