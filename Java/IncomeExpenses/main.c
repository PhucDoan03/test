#include <stdio.h>
#include <stdlib.h>
#include "Transaction.h"
#include "Transactionlist.h"
#include "Calculation.h"
#include "UI.h"

int main()
{
    List *transactionList = createList();
    if (transactionList == NULL)
    {
        printf("Failed to initialize transaction list.\n");
        return 1;
    }

    int choice;
    int index;
    Transaction transaction;
    double totalIncome, totalExpense, balance;

    // Main loop to run the program
    while (1)
    {
        // Display the main menu and get the user's choice
        choice = displayMainMenu();

        switch (choice)
        {
        case 1:
            // Add a new transaction
            transaction = promptNewTransaction();
            if (addToList(transactionList, transaction) == 0)
            {
                displayMessage("Transaction added successfully.");
            }
            else
            {
                displayMessage("Failed to add transaction.");
            }
            break;

        case 2:
            // Edit an existing transaction
            index = promptTransactionIndex(transactionList);
            if (index >= 0)
            {
                transaction = promptNewTransaction();
                // Changed to pass head of list to editTransaction function
                if (editTransaction(transactionList->head, index, transaction) == 0)
                {
                    displayMessage("Transaction edited successfully.");
                }
                else
                {
                    displayMessage("Failed to edit transaction.");
                }
            }
            break;

        case 3:
            // Delete a transaction
            index = promptTransactionIndex(transactionList);
            if (index >= 0)
            {
                if (removeFromList(transactionList, index) == 0)
                {
                    displayMessage("Transaction deleted successfully."); // Added missing semicolon
                }
                else
                {
                    displayMessage("Failed to delete transaction.");
                }
            }
            break;

        case 4:
            // View all transactions
            displayTransactions(transactionList);
            break;

        case 5:
            // Calculate and display totals
            totalIncome = calculateTotalIncome(transactionList);
            totalExpense = calculateTotalExpense(transactionList);
            balance = calculateBalance(transactionList);
            displayTotals(totalIncome, totalExpense, balance);
            break;

        case 6:
            // Exit the program
            displayMessage("Exiting the program.");
            freeList(transactionList);
            return 0;

        default:
            displayMessage("Invalid choice. Please try again.");
        }
    }

    return 0;
}
