package com.ps.dealership_api_starter.models;

public class Vehicle {
    private double minPrice;
    private double maxPrice;

    private String Make;
    private String Model;

    private int minYear;

    private int maxYear;

    private String Color;

    private String type;

    private int Vin;

    public Vehicle(double minPrice, double maxPrice, String make, String model, int minYear,
                   int maxYear, String color, String type, int vin) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        Make = make;
        Model = model;
        this.minYear = minYear;
        this.maxYear = maxYear;
        Color = color;
        this.type = type;
        Vin = vin;
    }

    public Vehicle(Integer vin, Integer year, String make, String model, String vehicleType, String color, Integer odometer, Double price, Boolean sold) {
    }

    public Vehicle(Integer vin, Integer year, String make, String model, 
                   String vehicleType, String color,  Double minPrice, Double maxPrice, String type) {
        
    }

    public Vehicle(Integer vin, Integer year, String make, String model, String s, String color, Double minPrice, Double maxPrice) {
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getMinYear() {
        return minYear;
    }

    public void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVin() {
        return Vin;
    }

    public void setVin(int vin) {
        Vin = vin;
    }
}