package Mastery3;

public abstract class Vehicle {
    private double fuelEconomyCity;
    private double fuelEconomyHwy;
    private int seatingCapacity;
    private double cargoVolume;

    public Vehicle(double city, double hwy, int seats, double cargo) {
        fuelEconomyCity = city;
        fuelEconomyHwy = hwy;
        seatingCapacity = seats;
        cargoVolume = cargo;
    }

    public double getFuelEconomyCity() {
        return fuelEconomyCity;
    }

    public double getFuelEconomyHwy() {
        return fuelEconomyHwy;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Type: " + getType()
            + "\nCity fuel economy: " + fuelEconomyCity + " L/100 km"
            + "\nHighway fuel economy: " + fuelEconomyHwy + " L/100 km"
            + "\nSeating capacity: " + seatingCapacity
            + "\nCargo volume: " + cargoVolume + " L";
    }
}