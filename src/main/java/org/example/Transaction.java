package org.example;

public class Transaction {
    String date;
    String category;
    double amount;
    String description;

    public Transaction(String date, String category, double amount, String description) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | " + amount + " | " + description;
    }
}
