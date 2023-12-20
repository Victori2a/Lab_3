import base.Human;
import element.Wind;
import enums.*;
import base.Location;
import item.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Location cemetery = new Location("кладбище", ItemType.QUIETLY, ItemType.BURIAL);
        Human director = new Human("директор", Occupation.DIR_FUNERAL_HOME);
        Human rachel = new Human("Рэчел");
        Book book = new Book("Евангелие от Матфея");
        Book fragment = new Fragment(book, "Пустите детей и не препятствуйте им приходить ко мне");
        Human luis = new Human("Луис");
        Human oz = new Human("Оз", Occupation.GRAVEDIGGER);
        Corpse gadge = new Corpse("Гэдж");
        Grave grave = new Grave(gadge);
        grave.setEdgeColor(Color.BRIGHT_GREEN);
        Coffin coffin = new Coffin(gadge, Color.WHITE, grave, true);
        Human irvin = new Human("Ирвин");
        irvin.setTypes(HumanType.EMBARRASED, HumanType.CONFUSED);
        irvin.head.getFace().setTypes(BodyType.EYES_BAG, BodyType.BRISTLE);
        cemetery.setPeople(irvin, luis, rachel, oz, director);
        irvin.hair.setTypes(BodyType.GRAY, BodyType.THIN);
        Basket[] basket = new Basket[5];
        for (int i = 0; i < basket.length; i++) {
            basket[i] = new Basket(Basket.flowers[(int) (Math.random() * Basket.flowers.length)]);
            basket[i].setLocation(cemetery);
        }
        Memorial memorial = new Memorial("Фиппс", ItemType.PSEUDO_ROMAN, ItemType.HUGE);
        Car car = new Car("грузовик", oz);
        car.setType(ItemType.INCONSPICUOUS);
        Car cars = new Car("машины");
        Human[] visitors = new Human[10];
        for (int i = 0; i < visitors.length; i++) {
            visitors[i] = new Human(" присутствующий");
            visitors[i].setLocation(cemetery);
            visitors[i].setThings(new Umbrella(Color.BLACK,ItemType.GOVERNMENT));
        }
        cemetery.setItems(fragment, grave, coffin,car,memorial);
        rachel.askedRead(director, fragment);
        luis.stand(grave.getEdge());
        luis.look(irvin);
        irvin.look(luis);
        luis.argue(irvin);
        System.out.println(Arrays.toString(irvin.head.getFace().getTypes()));
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
        if (luis.hasType(HumanType.CONFUSED)){
            luis.understand();
        }
        car.stand(memorial);
        oz.smoke();
        oz.putInCar(coffin, car);
        oz.drive(car);
        director.say(" Аминь");
        luis.takeBodyPart(rachel.hands);
        rachel.tryToProtest();
        luis.stand(cars);
        for (int i = 0; i < cemetery.getPeople().length; i++) {
            director.setThings(cemetery.getPeople()[i].getThings());
        }
    }
}