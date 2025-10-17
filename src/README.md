# Personal Finance Ledger Application


## Overview

It allows users to record deposits and payments, track their balance,
and generate different financial reports.
All transactions are saved in a CSV file so the data is stored even 
after the program closes.

The main goal of this project is to help users manage and review 
their financial activity by date, type, and vendor.

##  Features List
Home Screen 
************

 - Add deposits (saves positive amounts)

 - Make payments (saves negative amounts)

- Access ledger to view transactions

 - Exit program 

Ledger Menu
************

- All Entries: Displays all transactions (newest first)

 - Deposits: Shows only positive transactions

- Payments: Shows only negative transactions

Reports Menu
*************
- Month To Date – Shows all transactions from the current month

- Previous Month – Shows last month’s transactions

- Year To Date – Displays transactions from the current year

- Previous Year – Displays last year’s transactions

- Search by Vendor – Lets the user find all transactions from a specific vendor


Challenges I Faced
*******************

One of the main challenges I had was creating and organizing multiple classes.

At first, it was confusing to understand what should go in each class and how they would interact with each other.

I had to figure out how to separate responsibilities between Main, Transaction, TransactionManager, Ledger, and Reports.

Once I started breaking down each class by its purpose — for example, keeping file reading/writing in

TransactionManager and menu logic in Main — everything started to make more sense and my project became easier to manage.


