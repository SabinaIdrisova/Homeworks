#include <stdio.h>
#include "ListArray.h"

struct ListArray
{
	int value[20];
	int first;
	int last;
};

ListArray *createList()
{
	ListArray *result = new ListArray;
	result->first = 0;
	result->last = 0;
	return result;
}

Position first(ListArray *list)
{
	return list->first;
}

Position next(int position, ListArray *list)
{
	return ++position;
}

void add(ListArray *list, int value)
{
	list->value[list->last] = value;
	list->last++;
}

void printEl(ListArray *list)
{
	Position position = first(list);
	for (int i = 0; i < lengthOfList(list); i++)
	{
        printf("%d ", retrieve(position, list));
	    position = next(position, list);
	}
}

void read(FILE *file, ListArray *list)
{
	file = fopen("test.txt", "r");
	int number = 0;
	while (!feof(file))
	{
		fscanf(file, "%d", &number);
		add(list, number);
	}
	fclose(file);
}

void deleteList(ListArray *list)
{
	delete list;
}

int retrieve(int position, ListArray *list)
{
	return list->value[position];
}

int lengthOfList(ListArray* list)
{
	return list->last;
}