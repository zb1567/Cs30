package Mastery3;

public class Minivan extends Vehicle {
    private boolean slidingDoors;

    public Minivan(double city, double hwy, int seats,
                   double cargo, boolean hasSlidingDoors) {
        super(city, hwy, seats, cargo);
        slidingDoors = hasSlidingDoors;
    }

    public boolean hasSlidingDoors() {
        return slidingDoors;
    }

    @Override
    public String getType() {
        return "Minivan";
    }

    @Override
    public String toString() {
        return super.toString()
            + "\nSliding doors: " + slidingDoors;
    }
}