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

    public void deposit(Double amount, LocalDateTime time, Customer customer, BankAccount bankAccount) {
        customer.bankAccount.balance += amount;
        customer.bankAccount.transaction.add(new Transaction(Transaction.Type.GAIN, time, amount));
        bankAccount.transaction.add(new Transaction(Transaction.Type.GAIN, time, amount));
        System.out.println("The amount has been successfully deposited.");

    }


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
