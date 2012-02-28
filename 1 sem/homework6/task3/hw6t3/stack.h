#pragma once

struct Stack;
Stack *createStack(); 
void push(Stack *stack, int value);
char pop(Stack *stack);
void deleteStack(Stack *stack);