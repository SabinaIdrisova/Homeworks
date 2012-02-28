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
	    printf("�������� ��������: 1 - �������� �������� � ���������\n 2 - ������� �������� �� ���������\n 3 - ���������, ����������� �� �������� ���������\n 4 - ���������� ������� �������� ��������� � ������������ �������\n 5 - ���������� ������� �������� ��������� � ��������� �������\n 0 - ����� �� ���������\n" );
	    scanf("%d", &operation);
	    if (operation == 1)
	    {
	        printf("������� ��������\n");
	        scanf("%d", &element);
	        add(root, element);
	    }
	    if (operation == 2)
	    {
		    printf("������� ��������\n");
	        scanf("%d", &element);
			clear(root, element);
	    }
	    if (operation == 3)
	    {
		    printf("������� ��������\n");
	        scanf("%d", &element);
		    if (check(root, element))
			    printf("������� ����������� ���������\n");
		    else
			    printf("������� �� ����������� ���������\n");
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