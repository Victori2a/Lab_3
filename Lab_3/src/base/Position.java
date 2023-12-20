package base;

public interface Position {
    public default void addPosition(Human human){
        human.addPos(this);
    }
    public default void addPosition(Item item){
        item.addPos(this);
    }
}
