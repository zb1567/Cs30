package Mastery;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LocalBankGUI implements ActionListener{

JFrame frame;
JPanel panel;
JButton addButton;
JButton depositButton;
JButton withdrawalButton;
JButton balanceButton;
JButton removeButton;
JButton quitButton;
JTextField accountField;
JTextField amountField;
JLabel display;

Bank bank=new Bank();
Account account;
Customer customer;

public LocalBankGUI(){

frame=new JFrame("Local Bank");
frame.setBounds(100,100,520,420);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

panel=new JPanel();
panel.setLayout(null);
frame.getContentPane().add(panel);

JLabel title=new JLabel("Local Bank");
title.setFont(new Font("Arial",Font.BOLD,24));
title.setBounds(190,20,200,40);
panel.add(title);

JLabel accountLabel=new JLabel("Account ID:");
accountLabel.setBounds(30,80,100,30);
panel.add(accountLabel);

accountField=new JTextField();
accountField.setBounds(130,80,180,30);
panel.add(accountField);

JLabel amountLabel=new JLabel("Amount:");
amountLabel.setBounds(30,120,100,30);
panel.add(amountLabel);

amountField=new JTextField();
amountField.setBounds(130,120,180,30);
panel.add(amountField);

addButton=new JButton("Add Account");
addButton.setBounds(30,170,135,35);
addButton.addActionListener(this);
panel.add(addButton);

depositButton=new JButton("Deposit");
depositButton.setBounds(180,170,135,35);
depositButton.addActionListener(this);
panel.add(depositButton);

withdrawalButton=new JButton("Withdrawal");
withdrawalButton.setBounds(330,170,135,35);
withdrawalButton.addActionListener(this);
panel.add(withdrawalButton);

balanceButton=new JButton("Check Balance");
balanceButton.setBounds(30,220,135,35);
balanceButton.addActionListener(this);
panel.add(balanceButton);

removeButton=new JButton("Remove Account");
removeButton.setBounds(180,220,135,35);
removeButton.addActionListener(this);
panel.add(removeButton);

quitButton=new JButton("Quit");
quitButton.setBounds(330,220,135,35);
quitButton.addActionListener(this);
panel.add(quitButton);

display=new JLabel(" ");
display.setBounds(30,275,450,60);
panel.add(display);

frame.setLocationRelativeTo(null);
frame.setVisible(true);
}

public void actionPerformed(ActionEvent e){

String action=e.getActionCommand();

if(action.equals("Add Account")){

String firstName=JOptionPane.showInputDialog("Enter first name:");
String lastName=JOptionPane.showInputDialog("Enter last name:");
String balanceText=JOptionPane.showInputDialog("Enter beginning balance:");

if(firstName!=null&&lastName!=null&&balanceText!=null){

try{

double beginningBalance=Double.parseDouble(balanceText);

customer=new Customer(firstName,lastName);

account=new Account(beginningBalance,customer);

bank.addAccount(account);

accountField.setText(account.getID());

display.setText("Account created. ID: "+account.getID());

}

catch(NumberFormatException ex){

display.setText("Enter a valid balance.");

}

}

}

else if(action.equals("Deposit")){

String id=accountField.getText();

try{

double amount=Double.parseDouble(amountField.getText());

if(bank.deposit(id,amount)){

display.setText("Deposit complete. Balance: $"+String.format("%.2f",bank.getBalance(id)));

}

else{

display.setText("Account not found or invalid amount.");

}

}

catch(NumberFormatException ex){

display.setText("Enter a valid amount.");

}

}

else if(action.equals("Withdrawal")){

String id=accountField.getText();

try{

double amount=Double.parseDouble(amountField.getText());

if(bank.withdrawal(id,amount)){

display.setText("Withdrawal complete. Balance: $"+String.format("%.2f",bank.getBalance(id)));

}

else{

display.setText("Not enough money or account not found.");

}

}

catch(NumberFormatException ex){

display.setText("Enter a valid amount.");

}

}

else if(action.equals("Check Balance")){

String id=accountField.getText();

if(bank.accountExists(id)){

display.setText("Balance: $"+String.format("%.2f",bank.getBalance(id)));

}

else{

display.setText("Account does not exist.");

}

}

else if(action.equals("Remove Account")){

String id=accountField.getText();

if(bank.deleteAccount(id)){

display.setText("Account removed.");

accountField.setText("");

amountField.setText("");

}

else{

display.setText("Account does not exist.");

}

}

else if(action.equals("Quit")){

System.exit(0);

}

}

public static void main(String[]args){

new LocalBankGUI();

}

}

class Bank{

private ArrayList<Account> accounts;

public Bank(){

accounts=new ArrayList<Account>();

}

public void addAccount(Account account){

accounts.add(account);

}

public boolean deleteAccount(String accountID){

Account account=findAccount(accountID);

if(account!=null){

accounts.remove(account);

return true;

}

return false;

}

public boolean deposit(String accountID,double amount){

Account account=findAccount(accountID);

if(account!=null&&amount>0){

account.deposit(amount);

return true;

}

return false;

}

public boolean withdrawal(String accountID,double amount){

Account account=findAccount(accountID);

if(account!=null&&amount>0){

return account.withdrawal(amount);

}

return false;

}

public double getBalance(String accountID){

Account account=findAccount(accountID);

if(account!=null){

return account.getBalance();

}

return 0;

}

public boolean accountExists(String accountID){

return findAccount(accountID)!=null;

}

private Account findAccount(String accountID){

for(int i=0;i<accounts.size();i++){

Account account=accounts.get(i);

if(account.getID().equalsIgnoreCase(accountID)){

return account;

}

}

return null;

}

}

class Account{

private double balance;
private Customer customer;
private String accountID;
private static int nextID=1000;

public Account(double balance,Customer customer){

this.balance=balance;

this.customer=customer;

accountID="A"+nextID;

nextID++;

}

public void deposit(double amount){

balance=balance+amount;

}

public boolean withdrawal(double amount){

if(amount<=balance&&amount>0){

balance=balance-amount;

return true;

}

return false;

}

public double getBalance(){

return balance;

}

public String getID(){

return accountID;

}

public Customer getCustomer(){

return customer;

}

public String toString(){

return customer+" Account ID: "+accountID+" Balance: $"+balance;

}

}

class Customer{

private String firstName;
private String lastName;

public Customer(String firstName,String lastName){

this.firstName=firstName;

this.lastName=lastName;

}

public String getFirstName(){

return firstName;

}

public String getLastName(){

return lastName;

}

public String toString(){

return firstName+" "+lastName;

}

}