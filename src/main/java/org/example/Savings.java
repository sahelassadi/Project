package org.example;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Savings extends BankAccount {
    private Stack<Transaction> transaction;

    public Savings() {

    }

    public Savings(Stack<Transaction> transaction) {
        this.transaction = transaction;

    }

    public void deposit(Double amount, LocalDateTime time, Customer customer, BankAccount bankAccount) {
        customer.bankAccount.balance += amount;
        customer.bankAccount.transaction.add(new Transaction(Transaction.Type.GAIN, time, amount));
        bankAccount.transaction.add(new Transaction(Transaction.Type.SPENT, time, amount));
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
        Savings savings = (Savings) o;
        return Double.compare(balance, savings.balance) == 0 && Objects.equals(transaction, savings.transaction);
    }

    @Override
    public String toString() {
        return "Savings: " + "\n" +
                "transaction: " + transaction;

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), transaction, balance);
    }

    public Stack<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Stack<Transaction> transaction) {
        this.transaction = transaction;
    }


}
