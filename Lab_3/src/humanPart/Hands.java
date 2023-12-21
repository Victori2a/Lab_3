package humanPart;

import base.Human;

public class Hands extends BodyPart {
    public Human hold = null;

    public Hands(String name, Human owner) {
        super("руки", owner);
    }
    public void take(BodyPart part){
        System.out.println("рука "+ this.getOwner()+" взяла "+ part.getName() + " " + part.getOwner());
        hold = part.getOwner();
    }

}
