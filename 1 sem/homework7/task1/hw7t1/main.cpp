#include <stdio.h>
#include "ListPointer.h"
#include <iostream>
//#include "ListArray.h"

using namespace std;

typedef ListPointer *List;
//typedef ListArray *List;

List merge(List newListOne, List newListTwo)
{
	Position headOne = first(newListOne);
	Position headTwo = first(newListTwo);
	List newList = createList();
	int length1 = lengthOfList(newListOne);
	int length2 = lengthOfList(newListTwo);
	while (length1 != 0 && length2 != 0)
	{
		if (retrieve(headOne, newListOne) <= retrieve(headTwo, newListTwo))
		{
			add(newList, retrieve(headOne, newListOne));
			headOne = next(headOne, newListOne);
			length1--;
		}
		else
		{
			add(newList, retrieve(headTwo, newListTwo));
			headTwo = next(headTwo, newListTwo);
			length2--;
		}
	}
	if (length2 == 0)
		while (length1 != 0)
		{
			add(newList, retrieve(headOne, newListOne));
			headOne = next(headOne, newListOne);
			length1--;
		}
	if (length1 == 0)
		while (length2 != 0)
		{
			add(newList, retrieve(headTwo, newListTwo));
			headTwo = next(headTwo, newListTwo);
			length2--;
		}
	deleteList(newListOne);
	deleteList(newListTwo);
	List newNewList = createList();
	headOne = first(newList);
	length1 = lengthOfList(newList);
	while (length1 != 0)
	{
		add(newNewList, retrieve(headOne, newList));
		headOne = next(headOne, newList);
		length1--;
	}
	deleteList(newList);
	return newNewList;
}

List mergeSort(List list)
{
	List newListOne = createList();
	List newListTwo = createList();
	int length = lengthOfList(list);
	if (length != 1)
	{
		Position temp = first(list);
		for (int i = 1; i <= length/2; ++i)
		{
			add(newListOne, retrieve(temp, list));
			temp = next(temp, list);
		}
		for (int i = length/2 + 1; i <= length; ++i)
		{
			add(newListTwo, retrieve(temp, list));
			temp = next(temp, list);
		}
		list = merge(mergeSort(newListOne), mergeSort(newListTwo));
	}
	return list;
}

int main()
{
	List procedure = createList();
	FILE *file = fopen("test.txt","r");
	read(file, procedure);
	fclose(file);
    printEl(mergeSort(procedure));
	printf("\n");
	return 0;
}