package item;

import base.Human;
import base.Item;
import base.Position;
import enums.Color;

public class Basket extends Item {
    public String name = "корзина";
    Flowers flower;
    public static Flowers[] flowers = Flowers.values();
    public Basket(Flowers flower){
        this.flower = flower;
    }
    public String getFlowers(){
        return this.flower.getName();
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
        return (name+", в которой " + this.getFlowers()+", ");
    }
}