#ifndef CALCULATION_H
#define CALCULATION_H

#include "Transactionlist.h"  // Ensure this correctly defines List, Node, and Transaction

// Calculates the total income from a list of transactions
// Returns the sum of all transactions marked as "income"
double calculateTotalIncome(const List *list);

// Calculates the total expenses from a list of transactions
// Returns the sum of all transactions marked as "expense"
double calculateTotalExpense(const List *list);

// Calculates the balance from a list of transactions
// Returns the difference between total income and total expenses
double calculateBalance(const List *list);

#endif
