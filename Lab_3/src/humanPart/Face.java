package humanPart;

import base.Human;
import enums.BodyType;

import java.util.Arrays;
import java.util.ArrayList;

public class Face extends BodyPart{
    protected ArrayList<BodyType> faceType = new ArrayList<>();
    public Face(String name, Human owner) {
        super("лицо", owner);
    }
    public void setTypes(BodyType... faceTypes){
        faceType.addAll(Arrays.asList(faceTypes));
    }
    public BodyType[] getTypes() {
        BodyType[] types1 = new BodyType[this.faceType.size()];
        return this.faceType.toArray(types1);
    }
    public boolean hasType(BodyType type) {
        return faceType.contains(type);
    }
}
