#include <stdio.h>
#include <string.h>  // Added for strcmp function
#include "Calculation.h"
#include "Transactionlist.h" // Ensure this is included for List and Node definitions

double calculateTotalIncome(const List *list)
{
    if (list == NULL || list->head == NULL)
    {
        return 0.0; // Return 0 if the list is empty
    }
    
    double totalIncome = 0.0;
    Node *current = list->head;

    // Iterate through the list and sum up the income transactions
    while (current != NULL)
    {
        // Ensure type comparison is safe and only checks "income"
        if (strcmp(current->data.type, "income") == 0)
        {
            totalIncome += current->data.amount;
        }
        current = current->next;
    }
    
    return totalIncome;
}

double calculateTotalExpense(const List *list)
{
    if (list == NULL || list->head == NULL)
    {
        return 0.0; // Return 0 if the list is empty
    }
    
    double totalExpense = 0.0;
    Node *current = list->head;

    // Iterate through the list and sum up the expense transactions
    while (current != NULL)
    {
        // Ensure type comparison is safe and only checks "expense"
        if (strcmp(current->data.type, "expense") == 0)
        {
            totalExpense += current->data.amount;
        }
        current = current->next;
    }
    
    return totalExpense;
}

double calculateBalance(const List *list)
{
    // Balance is total income minus total expenses
    double totalIncome = calculateTotalIncome(list);
    double totalExpense = calculateTotalExpense(list);

    return totalIncome - totalExpense;
}
