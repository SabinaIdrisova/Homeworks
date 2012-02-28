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
		printf("Выберите операцию для выполнения:\n0 - выход\n1 - добавить запись\n2 - найти телефон по имени\n3 - найти имя по телефону\n4 - сохранить текущие данные в файл\n");
		scanf("%d", &command);
		if (command == 1)
		{
			int number = 0;
			char name[size];
			printf("Введите имя и номер\n");
			scanf("%s %d", name, &number);
			addContact(name, number, list);
		}

		if (command == 2)
		{
			printf("Введите имя\n");
			char name[size];
			scanf("%s", name);
			searchByName(name, list);
		}

		if (command == 3)
		{
			printf("Введите номер телефона\n");
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