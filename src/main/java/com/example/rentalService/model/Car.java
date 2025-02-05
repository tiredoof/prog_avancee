package com.example.rentalService.model;

public class Car {

        private String plateNumber;
        private String brand;
        private double price;
        private boolean rented; // Indique si la voiture est louée

        // Constructeur, getters et setters
        public Car(String plateNumber, String brand, double price) {
            this.plateNumber = plateNumber;
            this.brand = brand;
            this.price = price;
            this.rented = false; // Par défaut, la voiture n'est pas louée
        }

        public String getPlateNumber() { return plateNumber; }
        public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

        public String getBrand() { return brand; }
        public void setBrand(String brand) { this.brand = brand; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public boolean isRented() { return rented; }
        public void setRented(boolean rented) { this.rented = rented; }

        @Override
        public String toString() {
            return "Car{" +
                    "plateNumber='" + plateNumber + '\'' +
                    ", brand='" + brand + '\'' +
                    ", price=" + price +
                    ", rented=" + rented +
                    '}';
        }
    }

