#ifndef TRANSACTION_H
#define TRANSACTION_H

// Define the Transaction struct
typedef struct
{
    char date[11];           // YYYY-MM-DD
    char type[10];           // "income" or "expenses"
    double amount;           // transaction amount
    char description[100];   // description of the transaction
} Transaction;

// Adds a new transaction
int addTransaction(Transaction **transactions, int *count, Transaction newTransaction);

// Edits an existing transaction
int editTransaction(Transaction *transactions, int count, int index, Transaction updatedTransaction);

// Deletes a transaction
int deleteTransaction(Transaction **transactions, int *count, int index);

#endif
