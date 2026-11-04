package Mastery2;

public class BusinessAcct extends Account {
    private static final double MINIMUM_BALANCE = 500.0;
    private static final double FEE = 10.0;

    public BusinessAcct(double bal, String fName, String lName,
                        String street, String city, String province,
                        String postalCode) {
        super(bal, fName, lName, street, city, province, postalCode);
    }

    @Override
    public void withdrawal(double amt) {
        boolean valid = Double.isFinite(amt)
                && amt > 0 && amt <= getBalance();

        super.withdrawal(amt);

        if (valid && getBalance() < MINIMUM_BALANCE) {
            chargeFee(FEE);
        }
    }
}