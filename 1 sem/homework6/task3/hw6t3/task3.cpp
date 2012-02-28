#include "stdio.h"
#include "stack.h"
#include "string.h"
#include "locale.h"

int main()
{
	setlocale(LC_ALL, "Rus");
	char str[100];
	char temp = 0;
	bool hasBalance = true;
	printf("Введите последовательность скобок:\n");
	scanf("%s", &str);
    Stack *stack = createStack();
	for (int i = 0; i < strlen(str); i++)
	{
		if (str[i] == '(' || str[i] == '{' || str[i] == '[')
			push(stack, str[i]);

		if (str[i] == '}' || str[i] == ')' || str[i] == ']')
		{
			temp = pop(stack);
			if (str[i] == ')')
				if (temp != '(')
				{
					hasBalance = false;
					break;
				}

				if (str[i] == '}')
					if (temp != '{')
					{
						hasBalance = false;
						break;
					}

					if (str[i] == ']')
						if (temp != '[')
						{
							hasBalance = false;
							break;
						}
		}
	}
    int a = pop(stack);
	if (a != NULL || !hasBalance)
		printf("Баланса скобок нет\n");
	else 
		printf("Баланс скобок\n");
	deleteStack(stack);
	return 0;
}
