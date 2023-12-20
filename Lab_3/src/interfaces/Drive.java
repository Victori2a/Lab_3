package interfaces;

import base.Item;
import item.Car;

public interface Drive {
    public void drive(Car car);
    public void putInCar(Item item, Car car);
    public void startCar(Car car);
}
