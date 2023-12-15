package Item;

import Base.Human;
import Base.Item;
import Base.Position;
import Enums.Color;

public class Basket extends Item {
    Flowers flower;
    Position position;
    public static Flowers[] flowers = Flowers.values();
    public Basket(Flowers flower){
        this.flower = flower;
    }
    public String getFlowers(){
        return this.flower.getName();
    }

    @Override
    public void action(Human human) {

    }
    public Color getColor() {
        return null;
    }
    public enum Flowers{
        ROSE("Розы"),
        TULIPS("Тюльпаны"),
        LILIES("Лилии");
        String name;
        Flowers(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
    public String toString(){
        return ("корзина, в которой " + this.getFlowers()+", ");
    }
}
