#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "UI.h"

int displayMainMenu()
{
    int choice;
    printf("\n=== Transaction Management System ===\n");
    printf("1. Add a new transaction\n");
    printf("2. Edit a transaction\n");
    printf("3. Delete a transaction\n");
    printf("4. View all transactions\n");
    printf("5. Calculate totals\n");
    printf("6. Exit\n");
    printf("Enter your choice: ");
    scanf("%d", &choice);

    // Clear input buffer to avoid unwanted behavior with scanf
    while (getchar() != '\n');

    return choice; // Corrected missing semicolon
}

Transaction promptNewTransaction()
{
    Transaction newTransaction;

    printf("\nEnter transaction details:\n");

    printf("Date (YYYY-MM-DD): ");
    fgets(newTransaction.date, sizeof(newTransaction.date), stdin);
    newTransaction.date[strcspn(newTransaction.date, "\n")] = 0; // Remove newline character

    printf("Type (income/expense): ");
    fgets(newTransaction.type, sizeof(newTransaction.type), stdin);
    newTransaction.type[strcspn(newTransaction.type, "\n")] = 0; // Remove newline character

    printf("Amount: ");
    if (scanf("%lf", &newTransaction.amount) != 1) {
        // Handle invalid input for amount
        printf("Invalid input for amount. Setting to 0.\n");
        newTransaction.amount = 0.0;
    }

    // Clear input buffer to avoid unwanted behavior with fgets
    while (getchar() != '\n');

    printf("Description: ");
    fgets(newTransaction.description, sizeof(newTransaction.description), stdin);
    newTransaction.description[strcspn(newTransaction.description, "\n")] = 0; // Remove newline character

    return newTransaction;
}

int promptTransactionIndex(const List *list)
{
    int index;

    if (list == NULL || list->head == NULL)
    {
        printf("The list is empty.\n");
        return -1;
    }
    
    displayTransactions(list);

    printf("\nEnter the index of the transaction: ");
    if (scanf("%d", &index) != 1) {
        // Handle invalid input for index
        printf("Invalid input. Please enter a valid index.\n");
        return -1;
    }

    // Clear input buffer to avoid unwanted behavior with scanf
    while (getchar() != '\n');

    if (index < 0)
    {
        printf("Invalid index.\n");
        return -1;
    }
    
    return index;
}

void displayTransactions(const List *list)
{
    if (list == NULL || list->head == NULL) // Corrected condition to use `==`
    {
        printf("No transactions to display.\n");
        return;
    }
    
    Node *current = list->head;
    int index = 0;

    printf("\n=== Transactions List ===\n");
    while (current != NULL)
    {
        printf("Transaction %d:\n", index);
        printf(" Date: %s\n", current->data.date);
        printf(" Type: %s\n", current->data.type);
        printf(" Amount: %.2f\n", current->data.amount);
        printf(" Description: %s\n", current->data.description);
        current = current->next;
        index++;
    }
}

void displayTotals(double totalIncome, double totalExpense, double balance)
{
    printf("\n=== Totals ===\n");
    printf("Total Income: %.2f\n", totalIncome);
    printf("Total Expenses: %.2f\n", totalExpense);
    printf("Balance: %.2f\n", balance);
}

void displayMessage(const char *message)
{
    printf("%s\n", message);
}
