#include <stdio.h>
#include "list.h"
#include <locale.h>

int main()
{
	setlocale(LC_ALL, "Rus");
	int position = 0;
	int number = 0;
	List *warriors = createList();
	printf("������� ���������� ������:\n");
	scanf("%d", &number);
    printf("������� �������:\n");
	scanf("%d", &position);
    while (number != 0)
	{
		int i = 0;
		add(number, warriors);
		i++;
		number = number - i;
	}
	ListElement *whichFollow = head(warriors);
	print(warriors);
    while (length(warriors) > 1)
	{
		ListElement *whichDelete = whichFollow;
		for (int i = 1; i < position; i++)
			whichDelete = next(whichDelete, warriors);
	    whichFollow = next(whichDelete, warriors);
		deleteElement(whichDelete, warriors);
		print(warriors);
	}
    printf("\n����� ��������� ������� �����, ������� ������ ����� �������� ���������:\n");
	print(warriors);
	return 0;
}