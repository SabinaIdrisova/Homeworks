#include <stdio.h>
#include "stack.h"

struct StackElement
{
	int value;
	StackElement *next;
};

struct Stack
{
	StackElement *head;
};

Stack *createStack()
{
	Stack *result = new Stack;
	result->head = NULL;
	return result;
};

void push(Stack *stack, int value)
{
	StackElement *newHead = new StackElement;
	newHead->next = stack->head;
	newHead->value = value;
	stack->head = newHead;
}

char pop(Stack *stack)
{
	if (stack->head != NULL)
	{
		char result = stack->head->value;
		StackElement *temp = stack->head;
		stack->head = stack->head->next;
		delete temp;
		return result;
	}
	else
		return NULL;
}

void deleteElements(StackElement *head)
{
	if (head != NULL)
	{
		deleteElements(head->next);
		delete head;
	}
}

void deleteStack(Stack *stack)
{
	deleteElements(stack->head);
	delete stack;
}
