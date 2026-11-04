package Mastery3;

public class Truck extends Vehicle {
    private double towingCapacity;

    public Truck(double city, double hwy, int seats,
                 double cargo, double towing) {
        super(city, hwy, seats, cargo);
        towingCapacity = towing;
    }

    public double getTowingCapacity() {
        return towingCapacity;
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public String toString() {
        return super.toString()
            + "\nTowing capacity: " + towingCapacity + " kg";
    }
}