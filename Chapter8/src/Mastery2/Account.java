package Mastery2;

import java.text.NumberFormat;

public class Account {
    private double balance;
    private Customer cust;
    private String acctID;

    public Account(double bal, String fName, String lName,
                   String street, String city, String province,
                   String postalCode) {
        balance = bal;
        cust = new Customer(
                fName, lName, street, city, province, postalCode);
        acctID = fName.substring(0, 1) + lName;
    }

    public Account(double bal, String fName, String lName) {
        this(bal, fName, lName, "", "", "", "");
    }

    public Account(String ID) {
        balance = 0;
        cust = new Customer("", "");
        acctID = ID;
    }

    public String getID() {
        return acctID;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        if (!Double.isFinite(amt) || amt <= 0) {
            System.out.println("Enter a positive deposit amount.");
        } else {
            balance += amt;
        }
    }

    public void withdrawal(double amt) {
        if (!Double.isFinite(amt) || amt <= 0) {
            System.out.println("Enter a positive withdrawal amount.");
        } else if (amt <= balance) {
            balance -= amt;
        } else {
            System.out.println("Not enough money in account.");
        }
    }

    protected void chargeFee(double fee) {
        balance -= fee;
    }

    public void changeAddress(String street, String city,
                              String province, String postalCode) {
        cust.changeStreet(street);
        cust.changeCity(city);
        cust.changeProvince(province);
        cust.changePostalCode(postalCode);
    }

    @Override
    public boolean equals(Object acct) {
        if (!(acct instanceof Account)) {
            return false;
        }

        Account testAcct = (Account) acct;
        return acctID.equals(testAcct.acctID);
    }

    @Override
    public int hashCode() {
        return acctID.hashCode();
    }

    @Override
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();

        return acctID + "\n"
                + cust.toString()
                + "Current balance is " + money.format(balance);
    }
}