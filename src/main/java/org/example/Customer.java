package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Customer implements CustomerDetails, Comparator<Customer> {
    protected String name;
    protected String username;
    protected BankAccount bankAccount;
    protected int sin;
    protected String dateOfBirth;
    protected String emailAddress;
    protected int creditScore;

    public Customer() {

    }

    public Customer(String name, String username, BankAccount bankAccount, int sin, String dateOfBirth, String emailAddress, int creditScore) {
        this.name = name;
        this.username = username;
        this.bankAccount = bankAccount;
        this.sin = sin;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.creditScore = creditScore;
    }

    /**
     * This allows the customer to view his account details
     * @param username the username of the customer
     * @param employee the object of the Employee class
     */
    @Override
    public void ViewAccountDetails(String username, Employee employee) {
        if (employee.listUsernames.containsKey(username)) {
            System.out.println(employee.listUsernames.get(username));
        } else {
            System.out.println("This username doesn't have an account");
        }
    }


    @Override
    public int compare(Customer o1, Customer o2) {
        return (o1.name.compareTo(o2.name)) * 10000
                + o1.creditScore - o2.creditScore;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return sin == customer.sin && creditScore == customer.creditScore && Objects.equals(name, customer.name) && Objects.equals(username, customer.username) && Objects.equals(bankAccount, customer.bankAccount) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(emailAddress, customer.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, bankAccount, sin, dateOfBirth, emailAddress, creditScore);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Username: " + username + "\n" + "BankAccount: " + bankAccount + "\n" + "sin: " + sin + "\n" + "dateOfBirth: " + dateOfBirth + "\n" + "emailAddress: " + emailAddress + "\n" + "creditScore: " + creditScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getSin() {
        return sin;
    }

    public void setSin(int sin) {
        this.sin = sin;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

}
