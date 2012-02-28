#include <stdio.h>
#include "st.h"

typedef struct Node* pnode;

struct Node 
{
	int value;
	pnode next;
};

void addValue(pnode &root, int x)
{
	pnode newNode = new Node;
	newNode->value = x;
	newNode->next = NULL;
	pnode cur = root;
	pnode prev = NULL;
	while (cur && cur->value < x) 
	{
		prev = cur;
		cur = cur->next;
	}
	newNode->next = cur;
	if (prev) 
		prev->next = newNode;
	else
		root = newNode;
}

void deleteValue(pnode &root, int x)
{
	pnode prev = NULL;
	pnode cur = root;
	while (cur && cur->value != x) 
	{
		prev = cur;
		cur = cur->next;
	}
	if (!cur) 
		return;
	if (prev)
		prev->next = cur->next;
	else 
		root = cur->next;
	delete cur;
}

void printList(pnode root) 
{
	printf("List: ");
	if (!root) 
		printf("Empty\n"); 
	while (root)
	{
		printf("%d ", root->value);
		root = root->next;
	}
	printf("\n");
}

void exit(pnode &root)
{
	while (root)
	{	
		Node *old = root;
		root = root->next;
		delete old;
	}	
}