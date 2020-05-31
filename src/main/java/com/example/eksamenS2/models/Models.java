package com.example.eksamenS2.models;

public class Models {

    private String Brand, Type, Engine, About, Model_number;
    private double Length;
    private boolean GearType, Aircon;
    private int km_L, year;

    public Models(String type, String model_number) {
        Type = type;
        Model_number = model_number;
    }

    public Models(String brand, String type, String engine, String about, double length, boolean gearType, boolean aircon, int km_L, int year) {
        Brand = brand;
        Type = type;
        Engine = engine;
        About = about;
        Length = length;
        GearType = gearType;
        Aircon = aircon;
        this.km_L = km_L;
        this.year = year;
    }

// Overloaded construktor til at oprette et tomt opjekt
    public Models(){}

// Overloaded constructor med model number
    public Models(String Model_number, String brand, String type, String engine, String about, double length, boolean gearType, boolean aircon, int km_L, int year) {
        this.Model_number = Model_number;
        Brand = brand;
        Type = type;
        Engine = engine;
        About = about;
        Length = length;
        GearType = gearType;
        Aircon = aircon;
        this.km_L = km_L;
        this.year = year;
    }

    public String getModel_number() { return Model_number; }

    public void setModel_number(String model_number) { Model_number = model_number; }

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

    public double getLength() {
        return Length;
    }

    public void setLength(double lenght) {
        Length = lenght;
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

    @Override
    public String toString() {
        return "Models{" +
                "Brand='" + Brand + '\'' +
                ", Type='" + Type + '\'' +
                ", Engine='" + Engine + '\'' +
                ", About='" + About + '\'' +
                ", Model_number='" + Model_number + '\'' +
                ", Length=" + Length +
                ", GearType=" + GearType +
                ", Aircon=" + Aircon +
                ", km_L=" + km_L +
                ", year=" + year +
                '}';
    }
}
