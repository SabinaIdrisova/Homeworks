#include <stdio.h>
#include "tree.h"
#include <locale.h>

int main()
{	
	setlocale(LC_ALL, "Rus");
	Node* root = NULL;
	int operation = 0;
	int element = 0;
	while (1)
	{
	    printf("Выберите действие: 1 - Добавить значение в множество\n 2 - Удалить значение из множества\n 3 - Проверить, принадлежит ли значение множеству\n 4 - Напечатать текущие элементы множества в возрастающем порядке\n 5 - Напечатать текущие элементы множества в убывающем порядке\n 0 - Выход из программы\n" );
	    scanf("%d", &operation);
	    if (operation == 1)
	    {
	        printf("Введите значение\n");
	        scanf("%d", &element);
	        add(root, element);
	    }
	    if (operation == 2)
	    {
		    printf("Введите значение\n");
	        scanf("%d", &element);
			clear(root, element);
	    }
	    if (operation == 3)
	    {
		    printf("Введите значение\n");
	        scanf("%d", &element);
		    if (check(root, element))
			    printf("Элемент принадлежит множеству\n");
		    else
			    printf("Элемент не принадлежит множеству\n");
	    }
	    if (operation == 4)
		    printUp(root);
	    if (operation == 5)
		    printDown(root);
		if (operation == 0)
		{
			exit(root);
			return 0;
		}
	}
}