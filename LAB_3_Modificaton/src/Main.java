import Base.*;
import Element.Wind;
import Enums.BodyType;
import Enums.Color;
import Enums.ItemType;
import Item.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human director = new Human("директор",Occupation.DIR_FUNERAL_HOME);
        Human rachel = new Human("Рэчел");
        Book book = new Book("Евангелие от Матфея");
        Book fragment = new Fragment(book,"Пустите детей и не препятствуйте им приходить ко мне");
        Human luis = new Human("Луис");
        Human oz = new Human("Оз", Occupation.GRAVEDIGGER);
        Corpse gadge = new Corpse("Гэдж");
        Grave grave = new Grave(gadge);
        grave.setEdgeColor(Color.BRIGHT_GREEN);
        Coffin coffin = new Coffin(gadge, Color.WHITE, grave, true);
        Human irvin = new Human("Ирвин");
        irvin.setTypes(HumanType.EMBARRASED, HumanType.CONFUSED);
        irvin.face.setTypes(BodyType.EYES_BAG, BodyType.BRISTLE);
        Location cemetery = new Location("кладбище", ItemType.QUIETLY,ItemType.BURIAL);
        cemetery.setPeople(irvin, luis,rachel);
        irvin.hair.setTypes(BodyType.GRAY, BodyType.THIN);
        Basket[] basket = new Basket[2];
        for (int i = 0; i < basket.length; i++) {
            basket[i] = new Basket(Basket.flowers[(int) (Math.random() * Basket.flowers.length)]);
        }
        Memorial memorial = new Memorial("Фиппс", ItemType.PSEUDO_ROMAN, ItemType.HUGE);
        cemetery.setItems(grave);
        Car car = new Car("катафалк", oz);
        car.setType(ItemType.INCONSPICUOUS);
        Car cars = new Car("машины");
        Human[] visitors = new Human[10];
        for (int i = 0; i< visitors.length; i++) {
            visitors[i] = new Human(" присутствующий");
            visitors[i].setLocation(cemetery);
            visitors[i].setThings(new Umbrella(Color.BLACK));
        }
        rachel.askedRead(director, fragment);
        luis.stand(grave.getEdge());
        luis.look(irvin);
        irvin.look(luis);
        luis.argue(irvin);
        System.out.println(Arrays.toString(irvin.face.getTypes()));
        System.out.println(Arrays.toString(irvin.hair.getTypes()));
        new Wind().blow(irvin.hair);
        luis.seem();
        luis.tryToPity();
        coffin.stand();
        luis.look(grave.getEdge());
        for (Basket bask : basket) {
            bask.stand(grave.getEdge());
        }
        oz.startCar(car);
        luis.look(cemetery);
        director.say(" 'Склоним головы в знак скорби'");
        visitors[2].bowHead();
        luis.look(car);
        luis.understand();
        car.stand(memorial);
        oz.smoke();
        oz.putInCar(coffin, car);
        oz.drive(car);
        director.say(" Аминь");
        luis.takeBodyPart(rachel.hands);
        rachel.tryToProtest();
        luis.stand(cars);
        for (int i = 0; i<cemetery.getPeople().length; i++){
              director.setThings(cemetery.getPeople()[i].getThings());
        }
        //System.out.println(Arrays.toString(director.getThings()));
    }
}