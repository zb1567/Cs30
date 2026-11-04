package Mastery3;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle car = new Car(
            8.0, 6.0, 5, 450.0, 4
        );

        Vehicle truck = new Truck(
            14.0, 10.0, 5, 1500.0, 3500.0
        );

        Vehicle minivan = new Minivan(
            11.0, 8.0, 7, 900.0, true
        );

        System.out.println(car);
        System.out.println();

        System.out.println(truck);
        System.out.println();

        System.out.println(minivan);
    }
}