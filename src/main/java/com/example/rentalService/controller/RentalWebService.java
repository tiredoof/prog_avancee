package com.example.rentalService.controller;

import com.example.rentalService.model.Car;
import com.example.rentalService.model.Dates;
//import com.example.rentalService.model.CarNotFoundException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RentalWebService {

    Logger logger = LoggerFactory.getLogger(RentalWebService.class);
    // Liste de voitures simulée (à remplacer par une base de données plus tard)
    //private final List<Car> cars = new ArrayList<>();
    private List<Car> cars = new ArrayList<Car>();

    // Constructeur pour ajouter des voitures par défaut
    public RentalWebService() {
        cars.add(new Car("AA11BB", "Ferrari", 100));
        cars.add(new Car("CC22DD", "Tesla", 80));
        cars.add(new Car("EE33FF", "BMW", 90));
        cars.add(new Car("BD55EE", "Toyota", 290));
        cars.add(new Car("CD77RR", "Toyota", 860));
        cars.add(new Car("FA88BB", "Tesla", 1200));
    }


    @GetMapping("/")
    public String Hello() {
        return "Hello Family !";
    }

    // Méthode pour récupérer la liste des voitures
    @GetMapping("/cars")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return cars;
    }


    // Méthode pour récupérer une voiture spécifique par numéro de plaque
    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public Car getACar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        return cars.stream()
                .filter(car -> car.getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst()
                .orElseThrow(() -> new Exception("Car with plate number " + plateNumber + " not found"));
    }

    /*@GetMapping("/cars/{plateNumber}")
    public Car getACar(@PathVariable("plateNumber") String plateNumber) throws CarNotFoundException {
        return cars.stream().filter(car -> car.getPlateNumber().equals(plateNumber)).findFirst().orElseThrow(() -> new CarNotFoundException(plateNumber));
    }*/

    //Méthode pour retouner la voiture
    /*@PutMapping("/cars/{plateNumber}")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public String returnCar(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent) throws Exception {

        // Vérifier si la requête a bien rent=false
        if (!rent) {
            // Rechercher la voiture dans la liste
            Car car = cars.stream()
                    .filter(c -> c.getPlateNumber().equalsIgnoreCase(plateNumber))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Car with plate number " + plateNumber + " not found"));

            // Mettre à jour le statut de location
            car.setRented(false);

            // Retourner une confirmation
            return "The car with plate number " + plateNumber + " has been successfully returned.";
        } else {
            throw new Exception("Invalid request. 'rent' parameter must be set to false.");
        }
    }*/



    //Méthode pour louer une voiture ou la retourner
    @PutMapping(value = "/cars/{plateNumber}")
    public void updateCarRentStatus(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent,
            @RequestBody(required = false) Dates dates) throws Exception {

        // Rechercher la voiture par son numéro de plaque
        Car car = cars.stream()
                .filter(c -> c.getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst()
                .orElseThrow(() -> new Exception("Car with plate number " + plateNumber + " not found"));

        // Mettre à jour l'état de location en fonction du paramètre rent
        car.setRented(rent);

        if (rent) { // Si la voiture est louée
            if (dates == null) {
                throw new Exception("Dates must be provided when renting a car.");
            }
            logger.info("Car rented: " + plateNumber + " from " + dates.getBegin() + " to " + dates.getEnd());
        } else { // Si la voiture est retournée
            logger.info("Car returned: " + plateNumber);
        }
    }


}
