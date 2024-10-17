#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Transaction.h"

int addTransaction(Transaction **transactions, int *count, Transaction newTransaction)
{
    Transaction *temp = realloc(*transactions, (*count + 1) * sizeof(Transaction));
    if (temp == NULL) {
        return -1; // Memory allocation failed
    }

    // Point transactions to the newly allocated memory
    *transactions = temp;

    // Add the new transaction
    (*transactions)[*count] = newTransaction;
    (*count)++;

    return 0;
}

int editTransaction(Transaction *transactions, int count, int index, Transaction updatedTransaction)
{
    if (index < 0 || index >= count) {
        return -1; // Index out of bounds
    }

    // Update the transaction at the specified index
    transactions[index] = updatedTransaction;

    return 0;
}

int deleteTransaction(Transaction **transactions, int *count, int index)
{
    if (index < 0 || index >= *count) {
        return -1; // Index out of bounds
    }

    // Shift transactions to remove the one at the specified index
    for (int i = index; i < *count - 1; i++) {
        (*transactions)[i] = (*transactions)[i + 1];
    }

    // Reallocate memory to shrink the array by one transaction
    Transaction *temp = realloc(*transactions, (*count - 1) * sizeof(Transaction));
    if (temp == NULL && *count - 1 > 0) {
        return -1; // Memory reallocation failed
    }

    // Point transactions to the newly allocated memory
    *transactions = temp;
    (*count)--;

    return 0;
}
