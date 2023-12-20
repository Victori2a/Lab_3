package item;

import base.Human;
import enums.HumanType;
import base.Item;
import enums.Color;

public class Cigarette extends Item {
    private String name = "сигарета";
    private boolean suitable = false;
    public Cigarette(boolean var){
        this.suitable = true;
    }
    private void goOut(){
        this.suitable = false;
    }

    @Override
    public void action(Human human) {
        //System.out.println(name+" плохо влияет на здоровье человека");
        human.setTypes(HumanType.UNHEALTHY);
        goOut();
    }
    public Color getColor() {
        return null;
    }
}
