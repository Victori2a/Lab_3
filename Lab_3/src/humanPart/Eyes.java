package humanPart;

import base.Human;
import enums.HumanType;

public class Eyes extends BodyPart{
    private double clarity;
    public Eyes(String name, Human owner) {
        super("глаза", owner);
        this.clarity = 1;
    }
    public void setClarity(double var){
        this.clarity += var;
    }
    public double getClarity(){
        return clarity;
    }
    @Override
    public void act(Human human) {
        System.out.println(getName()+" "+human + " сщурились из-за яркости" );
        human.setTypes(HumanType.BLINDED);
        human.removeType(HumanType.BLINDED);
    }
}
