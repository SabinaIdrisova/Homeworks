#include <stdio.h>
#include <string.h>
#include "stack.h"

int makeOperation(char sign, int a, int b)
{
	int result = 0;
	if (sign == '+')
		result = (b + a);
	if (sign == '-')
		result = (b - a);
	if (sign == '*')
		result = (b * a);
	if (sign == '/')
		result = (b / a);
	if (sign == '^')
		result = (b ^ a);
	return result;
}

bool isSymbol(char symbol)
{
	return ((symbol == '+') || (symbol =='-') || (symbol == '*') || (symbol =='/')  || (symbol =='^'));
}

int main()
{
	pst head = NULL;
	printf("vvedyte vyrazhenye\n");
	char s[60];
	scanf("%s", s);
	int length = strlen(s);
	for(int i = 0; i < length; i++)
	{
		if (!isSymbol(s[i]))
			push(head, s[i] - '0');
		else 
			if (isSymbol(s[i]))
			{
				int a = front(head);
				pop(head);
				int b = front(head);
				pop(head);
				push(head, makeOperation(s[i], a, b));
			}
	}
	printf("result = ");
	printf("%d\n",front(head));
	deleteStack(head);
	return 0;
}