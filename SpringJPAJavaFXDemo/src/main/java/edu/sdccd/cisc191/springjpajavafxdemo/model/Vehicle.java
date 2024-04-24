package edu.sdccd.cisc191.springjpajavafxdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Vehicle {
    @Id
    private String manufacturerName;
    private int milesOnVehicle;
    private int price;
    private int numberOfSeats;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Option> options;

    public Vehicle(String manufacturerName, int milesOnVehicle, int price, int numberOfSeats, List<Option> options) {
        this.manufacturerName = manufacturerName;
        this.milesOnVehicle = milesOnVehicle;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.options = options;
    }
    public Vehicle(){}

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getMilesOnVehicle() {
        return milesOnVehicle;
    }

    public void setMilesOnVehicle(int milesOnVehicle) {
        this.milesOnVehicle = milesOnVehicle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Option> getOptions() {
        return options;
    }

    public String getOptionsAsString() {
        return options.stream().map(option -> option.getDetails()).collect(Collectors.joining(","));
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturerName='" + manufacturerName + '\'' +
                ", milesOnVehicle=" + milesOnVehicle +
                ", price=" + price +
                ", numberOfSeats=" + numberOfSeats +
                ", options=" + options +
                '}';
    }
}
