package Base;

import Base.Human;
import Base.Item;

public interface Position {
    public default void addPosition(Human human){
        human.addPos(this);
    }
    public default void addPosition(Item item){
        item.addPos(this);
    }
}
