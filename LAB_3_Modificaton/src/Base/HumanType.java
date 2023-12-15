package Base;

public enum HumanType {
    EMBARRASED("смущённый"),
    CONFUSED("растерянный"),
    COMPASSIONATE("сострадательный"),

    INSENSITIVE("бесчувственный"),
    SMOKING("курящий"),
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
