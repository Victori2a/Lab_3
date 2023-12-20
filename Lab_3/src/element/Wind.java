package element;

import humanPart.Hair;

public class Wind {
    public String name = "ветер";
    public void blow(Hair hair){
        System.out.println(name+" потрепал волосы "+ hair.getOwner()+ "а");
        hair.disheveled();
        hair.stylishLook -= 3;
    }
}
