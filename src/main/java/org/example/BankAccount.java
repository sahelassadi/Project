package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BankAccount {
    protected List<Transaction> transaction;
    protected double balance;

    public BankAccount() {
        this.transaction = new ArrayList<>();
    }

    public BankAccount(List<Transaction> transaction, double balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public void TransactionHistory(BankAccount bankAccount) {
        Collections.sort(bankAccount.transaction);
        System.out.println(bankAccount.transaction);
    }

    public void balance(Customer customer, String username) {
        System.out.println("Balance of " + username + ": " + customer.bankAccount.balance);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(balance, that.balance) == 0 && Objects.equals(transaction, that.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, balance);
    }

    @Override
    public String toString() {
        return "\n" +
                "accountNumber: " + "\n" +
                "balance: " + balance;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
}
