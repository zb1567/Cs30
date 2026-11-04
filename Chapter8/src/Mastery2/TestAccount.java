package Mastery2;

import java.util.Scanner;

public class TestAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account personal = new PersonalAcct(
                150.0, "Zubair", "Bechir",
                "10 Main Street", "Calgary", "AB", "T2A 1A1");

        Account business = new BusinessAcct(
                600.0, "Sam", "Smith",
                "20 Main Street", "Calgary", "AB", "T2B 2B2");

        System.out.println("PERSONAL ACCOUNT");

        personal.withdrawal(50.0);
        System.out.printf("At minimum: $%.2f%n",
                personal.getBalance());

        personal.withdrawal(10.0);
        System.out.printf("After withdrawal and $2 fee: $%.2f%n",
                personal.getBalance());

        personal.deposit(50.0);
        System.out.printf("After $50 deposit: $%.2f%n",
                personal.getBalance());

        System.out.println("\nBUSINESS ACCOUNT");

        business.withdrawal(100.0);
        System.out.printf("At minimum: $%.2f%n",
                business.getBalance());

        business.withdrawal(50.0);
        System.out.printf("After withdrawal and $10 fee: $%.2f%n",
                business.getBalance());

        business.withdrawal(1000.0);
        System.out.printf("After rejected withdrawal: $%.2f%n",
                business.getBalance());

        System.out.println("\nChange personal account address:");

        System.out.print("Enter street: ");
        String street = input.nextLine();

        System.out.print("Enter city: ");
        String city = input.nextLine();

        System.out.print("Enter province: ");
        String province = input.nextLine();

        System.out.print("Enter postal code: ");
        String postalCode = input.nextLine();

        personal.changeAddress(street, city, province, postalCode);

        System.out.println("\nUPDATED PERSONAL ACCOUNT");
        System.out.println(personal);

        input.close();
    }
}