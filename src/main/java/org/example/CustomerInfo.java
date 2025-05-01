package org.example;

public class CustomerInfo extends Manager implements CustomerDetails{
    private String emailAddress;
    private int dateOfBirth;

    public CustomerInfo(String emailAddress, int dateOfBirth) {

    }

    public CustomerInfo(String name, int SIN, String emailAddress, int dateOfBirth) {

    }

    /**
     * customer's credit score, net worth of bank accounts, account activity, etc.
     */
    public void CustomerRecords(String name, int sin, String emailAddress, int dateOfBirth ) {

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

    public String getEmailAddress() {

    }

    public void setEmailAddress(String emailAddress) {

    }

    public int getDateOfBirth() {

    }

    public void setDateOfBirth(int dateOfBirth) {

    }
}
