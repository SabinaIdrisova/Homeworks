#include <stdio.h>
#include "tree.h"
#include <locale.h>

void operations()
{
	printf("Выберите действие: 1 - Добавить значение в множество\n");
	printf(" 2 - Удалить значение из множества\n");
	printf(" 3 - Проверить, принадлежит ли значение множеству\n");
	printf(" 4 - Напечатать текущие элементы множества в возрастающем порядке\n");
	printf(" 5 - Напечатать текущие элементы множества в убывающем порядке\n");
	printf(" 0 - Выход из программы\n" );
}

int main()
{	
	setlocale(LC_ALL, "Rus");
	Node* root = NULL;
	int operation = 0;
	int element = 0;
	while (true)
	{
	    operations();
	    scanf("%d", &operation);
		switch (operation)
		{
		    case 1:
	        {
	            printf("Введите значение\n");
	            scanf("%d", &element);
	            add(root, element);
			    break;
	        }
		    case 2:
	        {
		        printf("Введите значение\n");
	            scanf("%d", &element);
			    remove(root, element);
			    break;
	        }
		    case 3:
	        {
		        printf("Введите значение\n");
	            scanf("%d", &element);
		        if (find(root, element) != NULL)
			        printf("Элемент принадлежит множеству\n");
				else
			        printf("Элемент не принадлежит множеству\n");
			    break;
	        }
		    case 4:
		    {
		        printUp(root);
				break;
		    }
		    case 5:
		    {
			    printDown(root);
			    break;
			}
		    case 0:
		    {
			    deleteTree(root);
			    return 0;
				break;
		    }
		}
	}
}