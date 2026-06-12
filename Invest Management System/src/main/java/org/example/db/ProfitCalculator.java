package org.example.db;

public class ProfitCalculator {
    public double calculateProfit(double balance, double profitPercentage) {
        return (balance * profitPercentage) / 100;
    }
}

