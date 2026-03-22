package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String filePath = "transactions.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String date = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);
                String description = parts[3];

                Transaction t = new Transaction(date, category, amount, description);

                transactions.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, Double> categoryTotals = new HashMap<>();
        for (Transaction t : transactions) {
            categoryTotals.put(
                    t.category,
                    categoryTotals.getOrDefault(t.category, 0.0) + t.amount
            );
        }

        System.out.println("\n--- Transactions ---");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        System.out.println("\n--- Category Totals ---");
        for (String category : categoryTotals.keySet()) {
            System.out.printf("%-12s -> %.2f\n",category, categoryTotals.get(category));
        }

        String maxCategory = "";
        double maxAmount = 0;

        for (String category : categoryTotals.keySet()) {
            double amount = categoryTotals.get(category);

            if (amount > maxAmount) {
                maxAmount = amount;
                maxCategory = category;
            }
        }

        System.out.println("\n--- Highest Spending ---");
        System.out.printf("%s -> %.2f\n", maxCategory, maxAmount);

        HashMap<String, Double> monthlyTotals = new HashMap<>();
        for (Transaction t : transactions) {
            String month = t.date.substring(0, 7);
            monthlyTotals.put(
                    month,
                    monthlyTotals.getOrDefault(month, 0.0) + t.amount
            );
        }
        System.out.println("\n--- Monthly Totals ---");
        for (String month : monthlyTotals.keySet()) {
            System.out.printf("%s -> %.2f\n", month, monthlyTotals.get(month));
        }

        double total = 0;

        for (Transaction t : transactions) {
            total += t.amount;
        }

        double avg = total / transactions.size();

        System.out.println("\n--- Unusual Transactions ---");
        for (Transaction t : transactions) {
            if (t.amount > avg) {
                System.out.println(t);
            }
        }
    }
}
