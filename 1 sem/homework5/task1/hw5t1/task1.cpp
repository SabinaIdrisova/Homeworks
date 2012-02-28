#include <stdio.h>
#include "phone.h"
#include <locale.h>
 
int main()
{
	int command = 1;
	int const size = 30;
	Phone *list = NULL;
	open(list);
	setlocale (LC_ALL, "Rus");
	while (command)
	{
		printf("�������� �������� ��� ����������:\n0 - �����\n1 - �������� ������\n2 - ����� ������� �� �����\n3 - ����� ��� �� ��������\n4 - ��������� ������� ������ � ����\n");
		scanf("%d", &command);
		if (command == 1)
		{
			int number = 0;
			char name[size];
			printf("������� ��� � �����\n");
			scanf("%s %d", name, &number);
			addContact(name, number, list);
		}

		if (command == 2)
		{
			printf("������� ���\n");
			char name[size];
			scanf("%s", name);
			searchByName(name, list);
		}

		if (command == 3)
		{
			printf("������� ����� ��������\n");
			int number = 0;
			scanf("%d", &number);
			searchByNumber(number, list);
		}

		if (command == 4)
		{
			save(list);
		}
	}
	exit(list);
    return 0;
}