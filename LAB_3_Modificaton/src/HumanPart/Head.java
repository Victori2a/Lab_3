package HumanPart;

import Base.Human;

public class Head extends BodyPart{
    private Eyes eyes;
    private Face face;
    public Head(String name, Human owner) {
        super("голова", owner);
        eyes = new Eyes("глаза", owner);
    }
    @Override
    public void act(Human human) {
        System.out.println("голова "+human+" наклонилась");
    }
}
