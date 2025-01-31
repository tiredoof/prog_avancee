package com.example.carrental;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarService {
    private Map<String, Car> cars = new HashMap<>();

    public CarService() {
        cars.put("11AA22", new Car("11AA22", "Ferrari", 100));
        cars.put("33BB44", new Car("33BB44", "Tesla", 80));
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (!car.isRented()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public Car getCar(String plateNumber) {
        return cars.get(plateNumber);
    }

    public boolean rentCar(String plateNumber) {
        Car car = cars.get(plateNumber);
        if (car != null && !car.isRented()) {
            car.rent();
            return true;
        }
        return false;
    }

    public boolean returnCar(String plateNumber) {
        Car car = cars.get(plateNumber);
        if (car != null && car.isRented()) {
            car.getBack();
            return true;
        }
        return false;
    }
}
