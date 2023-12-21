package enums;

public enum HumanType {
    EMBARRASSED("смущённый"),
    CONFUSED("растерянный"),
    COMPASSIONATE("сострадательный"),
    INSENSITIVE("бесчувственный"),
    SMOKING("курящий"),
    PERSISTENT("настойчивый"),
    COMPLIANT("уступчивый"),
    SAD("грустный"),
    BLINDED("ослеплённый");
    String name;
    HumanType(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
