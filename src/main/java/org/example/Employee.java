package org.example;

import java.util.*;

public class Employee implements CustomerDetails {
    protected List<Customer> customerList;
    protected Map<String, Customer> listUsernames;
    protected List<Customer> deletedCustomer;


    public Employee() {
        this.customerList = new ArrayList<>();
        this.listUsernames = new HashMap<>();
        this.deletedCustomer = new ArrayList<>();
    }

    public Employee(List<Customer> customerList, Map<String, Customer> listUsernames, List<Customer> deletedCustomer) {
        this.customerList = customerList;
        this.listUsernames = listUsernames;
        this.deletedCustomer = deletedCustomer;
    }


    public boolean checkAccount(int sin) {
        if (customerList == null) {
            return true;
        }
        for (Customer customers : customerList) {
            if (customers.getSin() == sin) {
                return false;
            }
        }

        return true;
    }

    /**
     *  this method adds a new account
     * @param name the customer name
     * @param sin the sin of the customer
     * @param dateOfBirth customer's date of birth
     * @param emailAddress customer's email address
     * @param creditScore customer's credit score
     */
    public void addAccount(String name, int sin, String dateOfBirth, String emailAddress, int creditScore) {
        String username = emailAddress.substring(0, emailAddress.indexOf('@')).toLowerCase();
        Customer customer = new Customer(name, username, new BankAccount(), sin, dateOfBirth, emailAddress, creditScore);
        BankSystem.openedCustomer.add(customer);
        customerList.add(customer);
        listUsernames.put(username, customer);
        BankSystem.export();
        System.out.println("Account has been made.");
    }

    /**
     * This method closes a customer's account
     * @param username the customer's username
     * @param employee the employee object of employee class
     */
    public void closeAccount(String username, Employee employee) {
        deletedCustomer.add(listUsernames.get(username));
        customerList.remove(listUsernames.get(username));
        BankSystem.closedCustomer.add(employee.listUsernames.get(username));
        employee.listUsernames.remove(username);
        BankSystem.export();
        System.out.println("Account has been closed");
    }

    /**
     * This method is abstract from the interface.
     * It allows to view the customer's details
     * @param username customer's username
     * @param employee the employee object of the Employee class
     */
    @Override
    public void ViewAccountDetails(String username, Employee employee) {
        System.out.println(employee.listUsernames.get(username));
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(customerList, employee.customerList) && Objects.equals(listUsernames, employee.listUsernames) && Objects.equals(deletedCustomer, employee.deletedCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerList, listUsernames, deletedCustomer);
    }

    @Override
    public String toString() {
        return "Customer List" + customerList + "\n" +
                "Deleted Customers: " + deletedCustomer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Map<String, Customer> getListUsernames() {
        return listUsernames;
    }

    public void setListUsernames(Map<String, Customer> listUsernames) {
        this.listUsernames = listUsernames;
    }

    public List<Customer> getDeletedCustomer() {
        return deletedCustomer;
    }

    public void setDeletedCustomer(List<Customer> deletedCustomer) {
        this.deletedCustomer = deletedCustomer;
    }

}
