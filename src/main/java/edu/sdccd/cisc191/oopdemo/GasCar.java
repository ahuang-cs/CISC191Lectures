package edu.sdccd.cisc191.oopdemo;

public class GasCar extends Car implements Combustible {
    private int fuelLevel = 0;

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public void tankUp() {
        fuelLevel = 100;
    }
}
