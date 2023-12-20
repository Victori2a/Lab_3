package enums;

public enum Occupation {
    GRAVEDIGGER(" могилщик"),
    DIR_FUNERAL_HOME("директор похоронного бюро, роспоряжавщийся церемонией ");
    String name;
    Occupation(String name){
        this.name=name;
    }
    @Override
    public String toString() {
        return name;
    }
}
