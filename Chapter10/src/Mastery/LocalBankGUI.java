package Mastery;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.NumberFormat;
public class LocalBankGUI implements ActionListener {
    JFrame frame;
    JPanel contentPane;
    JTextField accountField, amountField;
    JButton addButton, depositButton, withdrawalButton;
    JButton balanceButton, removeButton, quitButton;
    JTextArea display;
    Bank bank = new Bank();
    public LocalBankGUI() {
        frame = new JFrame("Local Bank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 2, 10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        contentPane.add(new JLabel("Account ID:"));
        accountField = new JTextField(15);
        contentPane.add(accountField);
        contentPane.add(new JLabel("Amount:"));
        amountField = new JTextField(15);
        contentPane.add(amountField);
        addButton = new JButton("Add Account");
        addButton.addActionListener(this);
        contentPane.add(addButton);
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        contentPane.add(depositButton);
        withdrawalButton = new JButton("Withdrawal");
        withdrawalButton.addActionListener(this);
        contentPane.add(withdrawalButton);
        balanceButton = new JButton("Check Balance");
        balanceButton.addActionListener(this);
        contentPane.add(balanceButton);
        removeButton = new JButton("Remove Account");
        removeButton.addActionListener(this);
        contentPane.add(removeButton);
        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        contentPane.add(quitButton);
        display = new JTextArea(5, 30);
        display.setEditable(false);
        frame.add(contentPane, BorderLayout.NORTH);
        frame.add(new JScrollPane(display), BorderLayout.CENTER);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        String id = accountField.getText().trim();
        try {
            if (eventName.equals("Add Account")) {
                String firstName = JOptionPane.showInputDialog(frame, "Enter first name:");
                if (firstName == null) {
                    return;
                }
                String lastName = JOptionPane.showInputDialog(frame, "Enter last name:");
                if (lastName == null) {
                    return;
                }
                firstName = firstName.trim();
                lastName = lastName.trim();
                if (firstName.isEmpty() || lastName.isEmpty()) {
                    display.setText("Enter a first and last name.");
                    return;
                }
                String balanceText = JOptionPane.showInputDialog(frame, "Enter beginning balance:");
                if (balanceText == null) {
                    return;
                }
                double balance = Double.parseDouble(balanceText);
                if (balance < 0 || Double.isNaN(balance) || Double.isInfinite(balance)) {
                    display.setText("Enter a valid balance of zero or more.");
                    return;
                }
                Account account = bank.addAccount(balance, firstName, lastName);
                accountField.setText(account.getID());
                display.setText("Account created.\n" + account);
            } else if (eventName.equals("Deposit")) {
                double amount = Double.parseDouble(amountField.getText());
                display.setText(bank.transaction(1, id, amount));
            } else if (eventName.equals("Withdrawal")) {
                double amount = Double.parseDouble(amountField.getText());
                display.setText(bank.transaction(2, id, amount));
            } else if (eventName.equals("Check Balance")) {
                display.setText(bank.checkBalance(id));
            } else if (eventName.equals("Remove Account")) {
                display.setText(bank.deleteAccount(id));
            } else if (eventName.equals("Quit")) {
                frame.dispose();
            }
        } catch (NumberFormatException e) {
            display.setText("Enter a valid number.");
        }
    }
    private static void runGUI() {
        new LocalBankGUI();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }
}
class Bank {
    private ArrayList<Account> accounts;
    public Bank() {
        accounts = new ArrayList<Account>();
    }
    public Account addAccount(double balance, String firstName, String lastName) {
        String baseID = firstName.substring(0, 1) + lastName;
        String id = baseID;
        int number = 2;
        while (accounts.indexOf(new Account(id)) > -1) {
            id = baseID + number;
            number++;
        }
        Account account = new Account(id, balance, firstName, lastName);
        accounts.add(account);
        return account;
    }
    public String transaction(int transCode, String acctID, double amt) {
        Account acctToMatch = new Account(acctID);
        int acctIndex = accounts.indexOf(acctToMatch);
        if (acctIndex == -1) {
            return "Account does not exist.";
        }
        if (amt <= 0 || Double.isNaN(amt) || Double.isInfinite(amt)) {
            return "Enter a valid positive amount.";
        }
        Account acct = accounts.get(acctIndex);
        if (transCode == 1) {
            acct.deposit(amt);
        } else if (transCode == 2) {
            if (amt > acct.getBalance()) {
                return "Not enough money in account.\n" + acct;
            }
            acct.withdrawal(amt);
        }
        return acct.toString();
    }
    public String checkBalance(String acctID) {
        Account acctToMatch = new Account(acctID);
        int acctIndex = accounts.indexOf(acctToMatch);
        if (acctIndex > -1) {
            Account acct = accounts.get(acctIndex);
            return acct.toString();
        } else {
            return "Account does not exist.";
        }
    }
    public String deleteAccount(String acctID) {
        Account acctToMatch = new Account(acctID);
        int acctIndex = accounts.indexOf(acctToMatch);
        if (acctIndex > -1) {
            accounts.remove(acctIndex);
            return "Account removed.";
        } else {
            return "Account does not exist.";
        }
    }
}
class Account {
    private String acctID;
    private double balance;
    private Customer cust;
    public Account(double bal, String fName, String lName) {
        balance = bal;
        cust = new Customer(fName, lName);
        acctID = fName.substring(0, 1) + lName;
    }
    public Account(String id, double bal, String fName, String lName) {
        balance = bal;
        cust = new Customer(fName, lName);
        acctID = id;
    }
    public Account(String id) {
        balance = 0;
        cust = new Customer("", "");
        acctID = id;
    }
    public String getID() {
        return acctID;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amt) {
        balance += amt;
    }
    public void withdrawal(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
        }
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        Account testAcct = (Account) obj;
        return acctID.equals(testAcct.acctID);
    }
    public int hashCode() {
        return acctID.hashCode();
    }
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return "Account ID: " + acctID + "\n" + cust
                + "Current balance: " + money.format(balance);
    }
}
class Customer {
    private String firstName;
    private String lastName;
    public Customer(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }
    public String toString() {
        return firstName + " " + lastName + "\n";
    }
}