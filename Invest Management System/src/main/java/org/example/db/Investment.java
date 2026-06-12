package org.example.db;


public class Investment {
    private double balance = 0.0;

    public void investMoney(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

