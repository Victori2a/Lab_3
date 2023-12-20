package humanPart;

import base.Human;

public class Head extends BodyPart{
    private Eyes eyes;
    private Face face;
    public Head(String name, Human owner) {
        super("голова", owner);
        eyes = new Eyes("глаза", owner);
        face = new Face("лицо",owner);
    }
    @Override
    public void act(Human human) {
        System.out.println("голова "+human+" наклонилась");
    }
    public Eyes getEyes(){
        return eyes;
    }
    public Face getFace(){
        return face;
    }
}
