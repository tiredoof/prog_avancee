package com.example.carrental;

public class Car {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rented;

    public Car(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = false;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getBrand() { return brand; }
    public int getPrice() { return price; }
    public boolean isRented() { return rented; }

    public void rent() { this.rented = true; }
    public void getBack() { this.rented = false; }
}
