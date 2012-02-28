#include <stdio.h>

int indexOfSymbol(char symbol)
{
	if (symbol == '/')
		return 0;
	else
	    if (symbol == '*')
			return 1;
		else 
			return 2;
}

int main()
{
	FILE *f1 = fopen("test.txt", "r");
	FILE *f2 = fopen("matrix.txt", "r");
	FILE *f3 = fopen("actions.txt", "r");
	int table[4][3];
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 3; j++)
			fscanf(f2, "%d", &table[i][j]);
	fclose(f2);
	int actions[4][3];
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 3; j++)
			fscanf(f3, "%d", &actions[i][j]);
	fclose(f3);
	int state = 0;
	char symbol = fgetc(f1);
	while (!feof(f1))
	{
		int const oldState = state;
		state = table[state][indexOfSymbol(symbol)];
		int const action = actions[oldState][indexOfSymbol(symbol)];
		if (action == 1)
			printf("/*");
		else
			if (action == 2)
				printf("%c", symbol);
		symbol = fgetc(f1);
	}
	fclose(f1);
	return 0;	
}