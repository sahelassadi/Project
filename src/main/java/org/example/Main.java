package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Employee employee = new Employee();
        Customer customer = new Customer();
        Chequing chequing = new Chequing();
        Savings savings = new Savings();
        Transaction transaction = new Transaction();
        BankAccount bankAccount = new BankAccount();
        System.out.println("Who is logging in? :");
        System.out.println("Customer or Manager");
        String user = in.next();
        boolean loop = true;
        while (loop) {
            if (user.equalsIgnoreCase("customer")) {
                if (!customerUI(employee, customer, transaction, chequing, savings, bankAccount)) {
                    loop = false;
                }
            }
            if (user.equalsIgnoreCase("manager")) {
                if (!managerUI(employee, customer, transaction, chequing, savings, bankAccount)) {
                    loop = false;
                }
            }
        }
        System.out.println("Thank you and have a good day!");
    }


    public static boolean customerUI(Employee employee, Customer customer, Transaction transaction, Chequing chequing, Savings savings, BankAccount bankAccount) {
        Scanner in = new Scanner(System.in);
        boolean loop1 = true;
        while (loop1) {
            System.out.println("What option would you like to do? :");
            System.out.println("- View Account Details");
            System.out.println("- Update Personal Details");
            System.out.println("- Review Transaction History");
            System.out.println("- Deposit");
            System.out.println("- Withdraw");
            System.out.println("- Check balance");
            System.out.println("- Change user");
            System.out.println("- Close Program");
            String option = in.nextLine();
            switch (option) {
                case "View Account Details":
                    System.out.println("Enter your username ");
                    String username = in.next().toLowerCase();
                    customer.ViewAccountDetails(username, employee);
                    break;

                case "Review Transaction History":
                    System.out.println("Enter your username: ");
                    String username2 = in.next();
                    if (employee.listUsernames.containsKey(username2)) {
                        System.out.println("Transaction from the bankaccount, chequing or savings?: ");
                        String account = in.next();
                        if (account.equalsIgnoreCase("bankaccount")) {
                            bankAccount.TransactionHistory(customer.bankAccount);
                        }
                        if (account.equalsIgnoreCase("chequing")) {
                            chequing.TransactionHistory(customer.bankAccount = chequing);
                        }
                        if (account.equalsIgnoreCase("savings")) {
                            savings.TransactionHistory(customer.bankAccount = savings);
                        }


                    } else {
                        System.out.println("This username doesn't have an account");
                    }

                    break;
                case "Deposit":
                    System.out.println("Enter your username: ");
                    String username3 = in.next();
                    if (employee.listUsernames.containsKey(username3)) {
                        System.out.println("What is the amount you would like to deposit?: ");
                        double amount = in.nextInt();
                        System.out.println("Would you like to deposit in chequing or savings");
                        String account = in.next();
                        LocalDateTime time = LocalDateTime.now();
                        if (account.equalsIgnoreCase("chequing")) {
                            chequing.deposit(amount, time, employee.listUsernames.get(username3), customer.bankAccount = chequing);
                        }
                        if (account.equalsIgnoreCase("savings")) {
                            savings.deposit(amount, time, employee.listUsernames.get(username3), customer.bankAccount = savings);
                        }
                    } else {
                        System.out.println("This username doesn't have an account");
                    }
                    break;
                case "Withdraw":
                    System.out.println("Enter your username: ");
                    String username4 = in.next();
                    if (employee.listUsernames.containsKey(username4)) {
                        System.out.println("What is the amount you would like to withdraw?: ");
                        double amount = in.nextInt();
                        System.out.println("Would you like to deposit in chequing or savings");
                        String account = in.next();
                        LocalDateTime time = LocalDateTime.now();
                        if (account.equalsIgnoreCase("chequing")) {
                            chequing.withdrawal(amount, time, employee.listUsernames.get(username4), customer.bankAccount = chequing);
                        }
                        if (account.equalsIgnoreCase("savings")) {
                            savings.withdrawal(amount, time, employee.listUsernames.get(username4), customer.bankAccount = savings);
                        }
                    } else {
                        System.out.println("This username doesn't have an account");
                        break;
                    }
                case "Check balance":
                    System.out.println("Enter your username: ");
                    String username5 = in.next();
                    if (employee.listUsernames.containsKey(username5)) {
                        bankAccount.balance(employee.listUsernames.get(username5), username5);
                    } else {
                        System.out.println("This username doesn't have an account");
                        break;
                    }
                case "Change user":
                    return true;
                case "Close Program":
                    loop1 = false;
                    break;
                default:
                    System.out.println("The option selected is not available.");
            }
        }
        return true;
    }

    public static boolean managerUI(Employee employee, Customer customer, Transaction transaction, Chequing chequing, Savings savings, BankAccount bankAccount) {
        Scanner in = new Scanner(System.in);
        boolean loop2 = true;
        while (loop2) {
            System.out.println("What option would you like to do? :");
            System.out.println("- Open Customer Account");
            System.out.println("- Close Customer Account");
            System.out.println("- Check Customer Balance");
            System.out.println("- Review Customer Transaction History");
            System.out.println("- Change user");
            System.out.println("- Close Program");
            String option = in.nextLine();
            switch (option) {
                case "Open Customer Account":
                    System.out.println("Enter the sin");
                    int sin = in.nextInt();
                    if (employee.checkAccount(sin)) {
                        System.out.println("Enter your full name: ");
                        String name = in.nextLine();
                        System.out.println("Enter your date of birth (year/month(2-digit)/day(2digit): ");
                        String dateOfBirth = in.nextLine();
                        System.out.println("Enter your email address: ");
                        String emailAddress = in.nextLine().toLowerCase();
                        System.out.println("Enter your credit score: ");
                        int creditScore = in.nextInt();
                        employee.addAccount(name, sin, dateOfBirth, emailAddress, creditScore);
                    } else {
                        System.out.println("This sin already has an account.");
                    }
                    break;
                case "Close Customer Account":
                    System.out.println("Enter the username");
                    String username = in.next();
                    if (employee.listUsernames.containsKey(username)) {
                        System.out.println(employee.listUsernames.get(username));
                        System.out.println("Is this the account that will be closed");
                        System.out.println("Once closed, this sin will not be able to open another account");
                        String answer = in.next();
                        if (answer.equalsIgnoreCase("yes")) {
                            employee.closeAccount(username, employee);
                        } else {
                            break;
                        }
                    }

                case "Check Customer Balance":
                    System.out.println("Enter the customer's username: ");
                    String username1 = in.next();
                    if (employee.listUsernames.containsKey(username1)) {
                        bankAccount.balance(employee.listUsernames.get(username1), username1);
                    } else {
                        System.out.println("This username doesn't have an account");
                        break;
                    }

                case "Customer Transaction History":
                    System.out.println("Enter the customer's username: ");
                    String username2 = in.next();
                    if (employee.listUsernames.containsKey(username2)) {
                        System.out.println("Transaction from the bankaccount, chequing or savings?: ");
                        String account = in.next();
                        if (account.equalsIgnoreCase("bankaccount")) {
                            bankAccount.TransactionHistory(customer.bankAccount);
                        }
                        if (account.equalsIgnoreCase("chequing")) {
                            chequing.TransactionHistory(customer.bankAccount = chequing);
                        }
                        if (account.equalsIgnoreCase("savings")) {
                            savings.TransactionHistory(customer.bankAccount = savings);
                        }

                    } else {
                        System.out.println("This username doesn't have an account");
                    }
                    break;
                case "Change user":
                    return true;
                case "Close Program":
                    loop2 = false;
                    break;
                default:
                    System.out.println("The option selected is not available.");
            }
        }
        return true;
    }
}






