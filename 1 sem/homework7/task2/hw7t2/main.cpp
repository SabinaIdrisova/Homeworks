#include <stdio.h>
#include "tree.h"
#include <locale.h>

void operations()
{
	printf("�������� ��������: 1 - �������� �������� � ���������\n");
	printf(" 2 - ������� �������� �� ���������\n");
	printf(" 3 - ���������, ����������� �� �������� ���������\n");
	printf(" 4 - ���������� ������� �������� ��������� � ������������ �������\n");
	printf(" 5 - ���������� ������� �������� ��������� � ��������� �������\n");
	printf(" 0 - ����� �� ���������\n" );
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
	            printf("������� ��������\n");
	            scanf("%d", &element);
	            add(root, element);
			    break;
	        }
		    case 2:
	        {
		        printf("������� ��������\n");
	            scanf("%d", &element);
			    remove(root, element);
			    break;
	        }
		    case 3:
	        {
		        printf("������� ��������\n");
	            scanf("%d", &element);
		        if (find(root, element) != NULL)
			        printf("������� ����������� ���������\n");
				else
			        printf("������� �� ����������� ���������\n");
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