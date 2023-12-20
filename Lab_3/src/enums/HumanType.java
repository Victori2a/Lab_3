package enums;

public enum HumanType {
    EMBARRASED("смущённый"),
    CONFUSED("растерянный"),
    COMPASSIONATE("сострадательный"),
    INSENSITIVE("бесчувственный"),
    UNHEALTHY("нездоровый"),
    PERSISTENT("настойчивый"),
    COMPLIANT("уступчивый"),
    UNHAPPY("неcчастный"),
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
