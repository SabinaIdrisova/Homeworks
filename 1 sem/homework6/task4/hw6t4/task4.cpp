#include <stdio.h>
#include <string.h>
#include "stack.h"

int priority(char symbol)
{
	if ((symbol == '(') || (symbol == ')'))
		return 1;
	else if ((symbol == '+') || (symbol == '-'))
		return 2;
	else if ((symbol == '*') || (symbol == '/'))
		return 3;
	else return 0;
}

int main()
{
	char infix[20];
	printf("vvedite vyragenie v infixnoi forme\n");
	gets(infix);
    int length = strlen(infix); 
	pst head = NULL;
	for (int i = 0; i < length; i++)
	{
		if (!priority(infix[i]))
			printf("%c", infix[i]);
		else
		{
			if ((head == NULL) || (priority(infix[i]) > priority(front(head))) || (infix[i] == '('))
				push(head, infix[i]);
			else
			{ 
				while (head != NULL)
				{
					if (front(head) != '(')
						printf("%c", front(head));
					pop(head);
				}
				if (infix[i] != ')')
				    push(head, infix[i]);
			}
		}
	}
	while(head != NULL)
	{
		printf("%c", front(head));
		pop(head);
	}
    printf("\n");
	return 0;
}