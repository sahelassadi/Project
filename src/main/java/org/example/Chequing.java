package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class Chequing extends BankAccount {
    private List<Transaction> transaction;


    public Chequing() {
        this.transaction = new ArrayList<>();
    }

    public Chequing(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    /**
     * This method allows to deposit an amount of money in the chequing account
     * @param amount the amount
     * @param time time of transaction
     * @param customer object of Customer class
     * @param bankAccount object of BankAccount class
     */
    public void deposit(Double amount, LocalDateTime time, Customer customer, BankAccount bankAccount) {
        customer.bankAccount.balance += amount;
        customer.bankAccount.transaction.add(new Transaction(Transaction.Type.GAIN, time, amount));
        bankAccount.transaction.add(new Transaction(Transaction.Type.GAIN, time, amount));
        System.out.println("The amount has been successfully deposited.");

    }

    /**
     * This method allows to withdraw an amount of money from the chequing account
     * @param amount the amount of money
     * @param time time of transaction
     * @param customer object of Customer class
     * @param bankAccount object of BankAccount class
     */
    public void withdrawal(Double amount, LocalDateTime time, Customer customer, BankAccount bankAccount) {
        if (amount > customer.bankAccount.balance) {
            System.out.println("The amount wished to withdraw is over the balance of the account");
            System.out.println("Amount cannot be withdrawn");
        } else {
            customer.bankAccount.balance -= amount;
            customer.bankAccount.transaction.add(new Transaction(Transaction.Type.SPENT, time, amount));
            bankAccount.transaction.add(new Transaction(Transaction.Type.SPENT, time, amount));
            System.out.println("The amount has been successfully withdraw.");
        }
    }

    /**
     * This method allows to view Transaction history
     * @param bankAccount the object of the BankAccount class
     */
    public void TransactionHistory(BankAccount bankAccount) {
        Collections.sort(bankAccount.transaction);
        System.out.println(bankAccount.transaction);

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chequing chequing = (Chequing) o;
        return Objects.equals(transaction, chequing.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), transaction);
    }

    @Override
    public String toString() {
        return "Chequing: " + "\n" +
                "transaction=" + transaction;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }


}
