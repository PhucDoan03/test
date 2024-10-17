#ifndef TRANSACTIONLIST_H
#define TRANSACTIONLIST_H

#include <stdio.h>
#include "Transaction.h" // Ensure this file defines the Transaction structure correctly

// Define a Node struct to hold a Transaction and a pointer to the next node
typedef struct Node
{
    Transaction data;    // The transaction data
    struct Node *next;   // Pointer to the next node in the list
} Node;

// Define the List struct, which holds a pointer to the head of the list
typedef struct
{
    Node *head;          // Pointer to the first node in the list
} List;

// Initializes a new empty list
List *createList(); // Allocates and initializes a new List structure

// Adds a new transaction to the list
int addToList(List *list, Transaction transaction); // Adds a transaction to the end of the list

// Removes a transaction from the list at a specified index
int removeFromList(List *list, int index); // Removes the transaction at the specified index

// Prints all transactions in the list
void printList(const List *list); // Prints details of all transactions in the list

// Frees all memory associated with the list
void freeList(List *list); // Frees the list and all associated nodes

#endif
