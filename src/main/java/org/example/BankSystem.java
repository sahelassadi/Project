package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BankSystem {

    public static final String OPEN_CUSTOMER_FILE_PATH = "src/main/resources/openCustomer.csv";
    public static final String CLOSED_CUSTOMER_FILE_PATH = "src/main/resources/openCustomer.csv";

    public static List<Customer> openedCustomer = readCustomer(OPEN_CUSTOMER_FILE_PATH);
    public static List<Customer> closedCustomer = readCustomer(CLOSED_CUSTOMER_FILE_PATH);


    private static List<Customer> readCustomer(String path) {
        List<Customer> customers = new ArrayList<>();

        File file = new File(path);
        int nextId;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                String username = parts[1];
                BankAccount bankAccount = new BankAccount();
                int sin = Integer.parseInt(parts[3]);
                String dateOfBirth = parts[4];
                String emailAddress = parts[5];
                int creditScore = Integer.parseInt(parts[6]);


                Customer customer = new Customer(name, username, bankAccount, sin, dateOfBirth, emailAddress, creditScore);
                customers.add(customer);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    /**
     * exports the current openedTickets and completedTickets to external files
     */
    public static void export() {
        writeCustomers(OPEN_CUSTOMER_FILE_PATH, openedCustomer);
        writeCustomers(CLOSED_CUSTOMER_FILE_PATH, closedCustomer);
    }


    private static void writeCustomers(String path, Collection<Customer> customers) {
        File file = new File(path);
        try (FileWriter fw = new FileWriter(file)) {
            for (Customer customer : customers) {
                fw.write(customer.getName() + ",");
                fw.write(customer.getUsername() + ",");
                fw.write(customer.getBankAccount() + ",");
                fw.write(customer.getSin() + ",");
                fw.write(customer.getDateOfBirth() + ",");
                fw.write(customer.getEmailAddress() + ",");
                fw.write(customer.getCreditScore());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




