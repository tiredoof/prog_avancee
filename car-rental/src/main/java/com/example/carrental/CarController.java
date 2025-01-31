package com.example.carrental;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Car> listOfCars() {
        return carService.getAvailableCars();
    }

    @GetMapping("/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCar(@PathVariable String plateNumber) {
        Car car = carService.getCar(plateNumber);
        if (car == null) {
            throw new RuntimeException("Car not found");
        }
        return car;
    }

    @PutMapping("/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrReturnCar(
            @PathVariable String plateNumber,
            @RequestParam boolean rent) {
        boolean success = rent ? carService.rentCar(plateNumber) : carService.returnCar(plateNumber);
        if (!success) {
            throw new RuntimeException("Action not possible");
        }
    }
}

