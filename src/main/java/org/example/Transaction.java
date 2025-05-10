package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> {
    private Type type;
    private LocalDateTime time;
    private double amount;

    public Transaction() {

    }

    public Transaction(Type type, LocalDateTime time, double amount) {
        this.type = type;
        this.time = time;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && type == that.type && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, time, amount);
    }

    @Override
    public String toString() {
        return "Transaction: " +
                "type: " + type + "\n" +
                "time: " + time + "\n" +
                "amount: " + amount + "\n" +
                '}';
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.amount, o.amount);
    }

    public enum Type {
        GAIN, SPENT
    }


}
