package HumanPart;

import Base.Human;

public abstract class BodyPart {
    private String name;
    private Human owner;
    public BodyPart(String name, Human owner) {
        this.name = name;
        this.owner = owner;
    }
    public Human getOwner() {
        return this.owner;
    }
    protected String getName(){
        return name;
    }
    public abstract void act(Human human);

}
