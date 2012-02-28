#include <stdio.h>
#include "nodes.h"

bool isSign(char symbol)
{
	return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
}

bool isDigit(char symbol)
{
	return symbol >= '0' && symbol <= '9';
}

int main()
{
	Node* cur = NULL;
	int buf = 0;
	FILE* f = fopen("test.txt", "r");
	while (!feof(f))
	{
		char symbol = fgetc(f);
		if (symbol != '(' && symbol != ' ')
		{
			if (isSign(symbol))
				cur = addChar(cur, symbol);
			if (symbol == ')')
				cur = cur->parent;
			if (isDigit(symbol))
			{
				ungetc(symbol, f);
				fscanf(f, "%d", &buf);
				cur = addValue(cur, buf);
			}
		}
	}
	while(cur->parent != NULL)
		cur = cur->parent;
	List *top = new List();
	Stack *stack = new Stack();
	stack->top = top;
	postorderPrint(cur, stack);
	printf("\n");
	printf("result = %d\n", stack->top->next->value);
	clearStack(stack);
}