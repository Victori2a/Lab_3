package humanPart;

import base.Human;
import enums.BodyType;
import java.util.ArrayList;
import java.util.Arrays;

public class Hair extends BodyPart{
    public double stylishLook = 15;
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
        System.out.println(getName() + " спутались. Ухоженность волос "+getOwner()+": " + stylishLook);
    }
    @Override
    public void act(Human human) {

    }
}