package Element;

import HumanPart.Hair;

public class Wind {
    public static final String name = "ветер";
    public void blow(Hair hair){
        System.out.println(name+" потрепал волосы "+ hair.getOwner()+ "а");
        hair.disheveled();
    }
}
