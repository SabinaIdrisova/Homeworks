#include <stdio.h>
#include "st.h"
#include "locale.h"

int main()
{
	setlocale (LC_ALL, "Rus");
	printf("0 - выход \n1 - добавить значение в сортированный список\n2 - удалить значение из списка\n3 - распечатать список\n\n");
	pnode root = NULL;
	int command = 1;
	int value = 0;
	while (command != 0)
	{
		printf("введите команду\n");
		scanf("%d", &command);
		if (command == 0)
		{ 
			printf("exit\n");
			break;
		}
		else if (command == 1) 
		{   printf("введите значение ");
			scanf("%d", &value);
			addValue(root, value);
		}
		else if (command == 2) 
		{	
			printf("введите число, которое необходимо удалить  ");
			scanf("%d", &value);
			deleteValue(root, value);
		}
		else if (command == 3)
			printList(root);
		else if (command > 3)
			printf("неправильная команда\n");
	}
	exit(root);
	return 0;
}

