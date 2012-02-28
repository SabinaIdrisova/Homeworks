#include <stdio.h>
#include "stack.h"

typedef struct Stack* pst;

struct Stack
	{
		int value;
		pst next;
	};

void push(pst &head, int a)
{
	pst newStack = new Stack;
	newStack->value = a;
	newStack->next = head;
	head = newStack;
}

void pop(pst &head)
{
	if (head)
    {	
		Stack *temp = head;
		head = head->next;
		delete temp;
	}	
}

int front(Stack *pst)
{
	if (pst)
		return pst->value;
	else 
		return -1;
}

