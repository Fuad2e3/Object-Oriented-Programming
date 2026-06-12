package org.example.db;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainController {
    @FXML private TextField nameField;
    @FXML private TextField regNumberField;
    @FXML private TextField amountField;
    @FXML private TextField profitPercentageField;
    @FXML private Label resultLabel;
    @FXML private VBox registerPane;
    @FXML private VBox investmentPane;

    private User user = new User();
    private Investment investment = new Investment();
    private ProfitCalculator profitCalculator = new ProfitCalculator();

    @FXML
    private void registerUser() {
        String name = nameField.getText();
        int regNumber;
        try {
            regNumber = Integer.parseInt(regNumberField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid registration number.");
            return;
        }

        user.setUserName(name);
        user.setUserNumber(regNumber);
        resultLabel.setText("Registration successful! Welcome, " + name + " (ID: " + regNumber + ")!");

        // Switch to the investment pane
        registerPane.setVisible(false);
        investmentPane.setVisible(true);
    }

    @FXML
    private void investMoney() {
        double amount;
        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid amount.");
            return;
        }

        if (amount > 0) {
            investment.investMoney(amount);
            resultLabel.setText("Investment successful!");
        } else {
            resultLabel.setText("Invalid amount. Please enter a positive value.");
        }
    }

    @FXML
    private void withdrawMoney() {
        double amount;
        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid amount.");
            return;
        }

        if (amount > 0 && amount <= investment.getBalance()) {
            investment.withdrawMoney(amount);
            resultLabel.setText("Withdrawal successful!");
        } else {
            resultLabel.setText("Invalid amount or insufficient balance.");
        }
    }

    @FXML
    private void calculateProfit() {
        double profitPercentage;
        try {
            profitPercentage = Double.parseDouble(profitPercentageField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid profit percentage.");
            return;
        }

        double profit = profitCalculator.calculateProfit(investment.getBalance(), profitPercentage);
        investment.setBalance(investment.getBalance() + profit);
        resultLabel.setText(String.format("Profit: $%.2f\nAvailable balance after profit: $%.2f", profit, investment.getBalance()));
    }

    @FXML
    private void seeMoney() {
        resultLabel.setText(String.format("Current balance: $%.2f", investment.getBalance()));
    }
}
