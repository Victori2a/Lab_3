package HumanPart;

import Base.Human;

import Enums.BodyType;

import java.util.ArrayList;
import java.util.Arrays;

public class Hair extends BodyPart{
    protected ArrayList<BodyType> hairTypes = new ArrayList<>();
    public Hair(String name, Human owner) {
        super("волосы", owner);
    }
    public void setTypes(BodyType... faceTypes){
        hairTypes.addAll(Arrays.asList(faceTypes));
    }
    public BodyType[] getTypes() {
        BodyType[] types1 = new BodyType[this.hairTypes.size()];
        return this.hairTypes.toArray(types1);
    }
    public void disheveled(){
        System.out.println(getName() + " спутались");
    }
    @Override
    public void act(Human human) {

    }
}
