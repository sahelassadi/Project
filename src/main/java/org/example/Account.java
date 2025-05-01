package org.example;

public class Account extends Customer implements CustomerDetails{
    private int dateOfBirth;
    private String emailAddress;

    public Account(int dateOfBirth, String emailAddress) {

    }

    public Account(String name, int SIN, int dateOfBirth, String emailAddress) {

    }

    /**
     * Show the account details of the customer
     */
    public void ViewAccountDetails(String name, int sin) {

    }

    /**
     * This method allows the customer to make changes to the customer details
     */
    @Override
    public void UpdateCustomerDetails() {

    }

    /**
     * Shows the transactions of the customer with his account
     */
    @Override
    public void ReviewTransactionHistory() {

    }

    @Override
    public boolean equals(Object o) {

    }

    @Override
    public int hashCode() {

    }

    @Override
    public String toString() {

    }

    public int getDateOfBirth() {

    }

    public void setDateOfBirth(int dateOfBirth) {

    }

    public String getEmailAddress() {

    }

    public void setEmailAddress(String emailAddress) {

    }
}
