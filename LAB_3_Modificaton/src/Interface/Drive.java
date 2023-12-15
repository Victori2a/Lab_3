package Interface;

import Item.Car;
import Base.Item;

public interface Drive {
    public void drive(Car car);
    public void putInCar(Item item, Car car);
    public void startCar(Car car);
}
