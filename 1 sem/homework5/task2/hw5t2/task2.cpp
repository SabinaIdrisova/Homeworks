#include <stdio.h>
#include "st.h"
#include "locale.h"

int main()
{
	setlocale (LC_ALL, "Rus");
	printf("0 - ����� \n1 - �������� �������� � ������������� ������\n2 - ������� �������� �� ������\n3 - ����������� ������\n\n");
	pnode root = NULL;
	int command = 1;
	int value = 0;
	while (command != 0)
	{
		printf("������� �������\n");
		scanf("%d", &command);
		if (command == 0)
		{ 
			printf("exit\n");
			break;
		}
		else if (command == 1) 
		{   printf("������� �������� ");
			scanf("%d", &value);
			addValue(root, value);
		}
		else if (command == 2) 
		{	
			printf("������� �����, ������� ���������� �������  ");
			scanf("%d", &value);
			deleteValue(root, value);
		}
		else if (command == 3)
			printList(root);
		else if (command > 3)
			printf("������������ �������\n");
	}
	exit(root);
	return 0;
}

