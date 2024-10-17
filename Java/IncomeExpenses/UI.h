#ifndef UI_H
#define UI_H

#include "Transactionlist.h" // Ensure this header correctly defines List, Node, Transaction

// Displays the main menu and returns the user's choice
int displayMainMenu(); 

// Prompts the user to enter a new transaction and returns it
Transaction promptNewTransaction(); 

// Prompts the user to select a transaction index for editing or deletion
// Returns the selected index or -1 if input is invalid
int promptTransactionIndex(const List *list); 

// Displays a list of all transactions
// Requires a pointer to a valid List structure
void displayTransactions(const List *list);

// Displays the calculated total income, total expenses, and balance
// Takes three double values representing income, expenses, and balance
void displayTotals(double totalIncome, double totalExpense, double balance);

// Displays a message to the user
// Takes a const char pointer to the message string
void displayMessage(const char *message);

#endif
