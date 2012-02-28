#include "stack.h"
#include <stdio.h>

void add(Stack* stack, int value)
{
	List *result = new List();
	result->next = stack->top->next;
	stack->top->next = result;
	result->value = value;
}

void remove(Stack *stack)
{
	List *temp = stack->top->next->next;
	stack->top->next->next = stack->top->next->next->next;
	delete (temp);
}

void calculate(Stack *stack, char symbol)
{
	if (symbol == '+')
		stack->top->next->value = stack->top->next->next->value + stack->top->next->value;
	if (symbol == '-')
		stack->top->next->value = stack->top->next->next->value - stack->top->next->value;
	if (symbol == '*')
		stack->top->next->value = stack->top->next->next->value * stack->top->next->value;
	if (symbol == '/')
		stack->top->next->value = stack->top->next->next->value / stack->top->next->value;
	remove(stack);
}

void clearStack(Stack *stack)
{
	List *cur = stack->top;
	if (cur->next != NULL)
		clearList(cur->next);
	delete stack->top;
	delete stack;
}

void clearList(List *list)
{
	if (list->next != NULL)
		clearList(list->next);
	delete list;
}