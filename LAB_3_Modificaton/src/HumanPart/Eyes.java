package HumanPart;

import Base.Human;
import Base.HumanType;

public class Eyes extends BodyPart{

    public Eyes(String name, Human owner) {
        super("глаза", owner);
    }
    @Override
    public void act(Human human) {
        System.out.println(getName()+" "+human + " сщурились из-за яркости" );
        human.setTypes(HumanType.BLINDED);
        human.removeType(HumanType.BLINDED);
    }
}
