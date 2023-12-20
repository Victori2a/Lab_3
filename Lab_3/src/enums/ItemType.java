package enums;

public enum ItemType {
    QUIETLY("тихо"),
    BURIAL(" всё покрыто могилами"),
    PSEUDO_ROMAN("псевдоримский"),
    INCONSPICUOUS("незаметный"),
    BRIGHT("яркий"),
    HUGE("огромный"),
    REPAIRED_LOCKS("с починенными замками"),
    GOVERNMENT("казённый");

    String name;
    ItemType(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}

