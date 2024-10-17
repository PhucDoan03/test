#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Transactionlist.h" // Ensure this file contains the definitions of Node and List

// Define the Node and List structures if not defined in the header
typedef struct Node {
    Transaction data;
    struct Node *next;
} Node;

typedef struct List {
    Node *head;
} List;

List *createList()
{
    List *list = (List *)malloc(sizeof(List)); // Corrected the cast to (List *)
    if (list == NULL) {
        return NULL; // Memory allocation failed
    }

    list->head = NULL; // Initialize the head pointer to NULL
    return list; // Added missing semicolon
}

int addToList(List *list, Transaction transaction)
{
    if (list == NULL) {
        return -1; // Invalid list pointer
    }

    // Allocate memory for the new node
    Node *newNode = (Node *)malloc(sizeof(Node));
    if (newNode == NULL) {
        return -1; // Memory allocation failed
    }

    // Set the transaction data and next pointer
    newNode->data = transaction;
    newNode->next = NULL;
    
    // If the list is empty, set the new node as the head
    if (list->head == NULL) {
        list->head = newNode;
    }
    else {
        // Traverse to the end of the list and add the new node
        Node *current = list->head;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = newNode;
    }

    return 0;
}

int removeFromList(List *list, int index)
{
    if (list == NULL || list->head == NULL || index < 0) {
        return -1; // Invalid list or empty list
    }

    Node *current = list->head;
    Node *previous = NULL;

    // Traverse to the node at the specified index
    for (int i = 0; i < index; i++) {
        if (current == NULL) {
            return -1; // Index out of bounds
        }
        previous = current;
        current = current->next;
    }
    
    // Remove the node from the list
    if (previous == NULL) {
        list->head = current->next; // Removing the first node
    } else {
        previous->next = current->next; // Removing a node other than the head
    }

    // Free the memory allocated for the node
    free(current);

    return 0; 
}

void printList(const List *list)
{
    if (list == NULL || list->head == NULL) {
        printf("The list is empty.\n");
        return;
    }
    
    Node *current = list->head;
    int index = 0;

    // Traverse and print each transaction
    while (current != NULL) {
        printf("Transaction %d:\n", index);
        printf(" Date: %s\n", current->data.date);
        printf(" Type: %s\n", current->data.type);
        printf(" Amount: %.2f\n", current->data.amount);
        printf(" Description: %s\n", current->data.description);
        current = current->next;
        index++;
    }
}

void freeList(List *list)
{
    if (list == NULL) {
        return;
    }
    
    Node *current = list->head;
    Node *nextNode;

    // Traverse and free each node
    while (current != NULL) {
        nextNode = current->next;
        free(current);
        current = nextNode;
    }
    
    // Free the list structure itself
    free(list);
}
