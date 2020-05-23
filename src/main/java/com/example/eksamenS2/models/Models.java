package com.example.eksamenS2.models;

public class Models {

    private String Brand, Type, Engine, About;
    private double Lenght;
    private boolean GearType, Aircon;
    private int km_L, year;

    public Models(String brand, String type, String engine, String about, double lenght, boolean gearType, boolean aircon, int km_L, int year) {
        Brand = brand;
        Type = type;
        Engine = engine;
        About = about;
        Lenght = lenght;
        GearType = gearType;
        Aircon = aircon;
        this.km_L = km_L;
        this.year = year;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public double getLenght() {
        return Lenght;
    }

    public void setLenght(double lenght) {
        Lenght = lenght;
    }

    public boolean isGearType() {
        return GearType;
    }

    public void setGearType(boolean gearType) {
        GearType = gearType;
    }

    public boolean isAircon() {
        return Aircon;
    }

    public void setAircon(boolean aircon) {
        Aircon = aircon;
    }

    public int getKm_L() {
        return km_L;
    }

    public void setKm_L(int km_L) {
        this.km_L = km_L;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}