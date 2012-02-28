#include <stdio.h>
#include <locale.h>
#include <string.h>

bool isDigit(char symbol)
{
	return symbol >= '0' && symbol <= '9';
}

int main()
{
	setlocale(LC_ALL, "Rus");
	char string[30];
	printf("Введите строку\n");
	scanf("%s", string);
	int state = 0;
	int i = 0;
	char symbol = string[i];
	while (i < strlen(string))
	{
		switch (state)
		{
		    case 0:
			    if (isDigit(symbol))
				{
					state = 1;
					i++;
				    symbol = string[i];
			    }
				else
				    state = -1;
				break;
			case 1:
			    if (isDigit(symbol))
				{
					state = 1;
					i++;
					symbol = string[i];
				}
				else
					if (symbol == '.')
					{
						state = 2;
						i++;
						symbol = string[i];
					}
					else 
						if (symbol == 'E')
						{
							state = 4;
							i++;
							symbol = string[i];
						}
						else
							state = -1;
				break;
			case 2:
				if (isDigit(symbol))
				{
					state = 3;
					i++;
					symbol = string[i];
				}
				else
					state = -1;
				break;
			case 3:
				if (isDigit(symbol))
				{
					state = 3;
					i++;
					symbol = string[i];
				}
				else
                    if (symbol == 'E')
					{
						state = 4;
						i++;
						symbol = string[i];
					}
					else
						state = -1;
				break;
			case 4:
				if (symbol == '+' || symbol == '-')
				{
					state = 5;
					i++;
					symbol = string[i];
				}
				else 
					if (isDigit(symbol))
					{
						state = 6;
						i++;
						symbol = string[i];
					}
				else
					state = -1;
				break;
			case 5:
				if (isDigit(symbol))
				{
					state = 6;
					i++;
					symbol = string[i];
				}
				else 
					state = -1;
				break;
			case 6:
				if (isDigit(symbol))
				{
					state = 6;
					i++;
					symbol = string[i];
				}
				else
					state = -1;
				break;
			case -1:
				printf("Нет\n");
				return 0;
		}
	}
	if (state == 1 || state == 3 || state == 6)
		printf("Да\n");
	if (state == 2 || state == 4 || state == 5)
		printf("Нет\n");
	return 0;
}