# CSV Transaction Analyzer

A Java-based transaction analysis system that processes CSV financial data and generates structured insights such as category-wise spending, monthly aggregation, and anomaly detection.

---

##  Features
- Category-wise spending analysis
- Monthly expense aggregation
- Highest spending category detection
- Unusual transaction detection

---

##  Sample Input (CSV)


date,category,amount,description
2025-06-01,Food,120.5,Lunch
2025-06-02,Transport,50,Bus
2025-06-03,Food,500,Dinner


---

##  Sample Output


--- Category Totals ---
Food → 620.50
Transport → 50.00

--- Highest Spending ---
Food → 620.50

--- Monthly Totals ---
2025-06 → 670.50

--- Unusual Transactions ---
Date | Category | Amount | Description
2025-06-03 | Food | 500.00 | Dinner


---

##  Tech Stack
- Java
- HashMap (for aggregation logic)
- File Handling (BufferedReader)

---

##  How It Works
- Reads transaction data from a CSV file
- Converts each row into a Transaction object
- Uses HashMap for efficient aggregation
- Outputs structured financial insights

---

## ️ How to Run
1. Place your CSV file in the folder which is same level of src
2. Run `Main.java`