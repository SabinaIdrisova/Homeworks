#pragma once

struct List
{
	int value;
	List *next;
};

struct Stack
{
	List *top;
};

void add(Stack* stack, int value);
void remove(Stack *stack);
void calculate(Stack *stack, char symbol);
void clearStack(Stack *stack);
void clearList(List *list);