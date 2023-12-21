package humanPart;

import base.Human;

public abstract class BodyPart {
    protected String name;
    protected Human owner;
    public BodyPart(String name, Human owner) {
        this.name = name;
        this.owner = owner;
    }
    public Human getOwner() {
        return this.owner;
    }
    public String getName(){
        return name;
    }

}
