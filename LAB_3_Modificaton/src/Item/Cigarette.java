package Item;

import Base.Human;
import Base.HumanType;
import Base.Item;
import Enums.Color;

public class Cigarette extends Item {
    private final String name = "сигарета";
    public boolean suitable = false;
    public Cigarette(boolean var){
        this.suitable = true;
    }
    public void goOut(){
        this.suitable = false;
    }

    @Override
    public void action(Human human) {
        System.out.println(name+" плохо влияет на здоровье человека");
        human.setTypes(HumanType.SMOKING, HumanType.UNHEALTHY);
        goOut();
    }
    public Color getColor() {
        return null;
    }
}