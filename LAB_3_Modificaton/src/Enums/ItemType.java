package Enums;

public enum ItemType {
    QUIETLY("тихо"),
    BURIAL(" всё покрыто могилами"),
    PSEUDO_ROMAN("псевдоримский"),
    INCONSPICUOUS("незаметный"),
    BRIGHT("яркий"),
    HUGE("огромный");
    String name;
    ItemType(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
