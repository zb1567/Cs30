package Mastery2;

public class Customer {
    private String firstName, lastName;
    private String street, city, province, postalCode;

    public Customer(String fName, String lName, String str,
                    String c, String prov, String postal) {
        firstName = fName;
        lastName = lName;
        street = str;
        city = c;
        province = prov;
        postalCode = postal;
    }

    public Customer(String fName, String lName) {
        this(fName, lName, "", "", "", "");
    }

    public void changeStreet(String newStreet) {
        street = newStreet;
    }

    public void changeCity(String newCity) {
        city = newCity;
    }

    public void changeProvince(String newProvince) {
        province = newProvince;
    }

    public void changePostalCode(String newPostalCode) {
        postalCode = newPostalCode;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n"
                + street + "\n"
                + city + ", " + province + " " + postalCode + "\n";
    }
}