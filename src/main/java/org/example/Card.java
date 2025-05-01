package org.example;

public class Card extends Customer {
    private int cardNumber;
    private int nip;
    private double amount;

    public Card(int cardNumber, int NIP, double amount) {

    }

    public Card(String name, int SIN, int cardNumber, int NIP, double amount) {

    }

    /**
     * allows the customer to make a deposit to his account
     * @param amount the amount deisred to deposit
     * @return the updated balancegit
     */
    public double Deposit(double amount) {

    }

    /**
     * allows the customer to make withdrawals from his account
     * @param amount the amount desired to withdraw
     * @return the updated balance
     */
    public double Withdrawal(double amount) {

    }

    /**
     * allows to take loan from the bank
     * @param amount the amount desired to loan
     * @return the updated balance of the account
     */
    public double Loan(double amount) {

    }

    /**
     * allows to make transfers between account or cards
     * @param amount the amount desired to transfer
     */
    public void Transfer(double amount) {

    }

    /**
     * the balance of the account with the modifications
     */
    public void balance() {

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

    public int getCardNumber() {

    }

    public void setCardNumber(int cardNumber) {

    }

    public int getNip() {

    }

    public void setNip(int nip) {

    }

    public double getAmount() {

    }

    public void setAmount(double amount) {

    }
}
