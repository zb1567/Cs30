package Mastery3;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(double city, double hwy, int seats,
               double cargo, int doors) {
        super(city, hwy, seats, cargo);
        numberOfDoors = doors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public String toString() {
        return super.toString()
            + "\nNumber of doors: " + numberOfDoors;
    }
}