#include <stdio.h>
#include <iostream>
#include "ListPointer.h"

struct ListElement
{
	int value;
	ListElement *next;
};

struct ListPointer
{
	ListElement *head;
};

ListPointer *createList()
{
	ListPointer *result = new ListPointer;
	result->head = NULL;
	return result;
}	

Position first(ListPointer *ListPointer)
{
	return ListPointer->head;
}

Position next(Position pos, ListPointer *ListPointer)
{
	if (ListPointer->head != NULL)
	{
		ListElement* temp = ListPointer->head;
		while (temp != pos && temp != NULL)
			temp = temp->next;
		if (temp != NULL)
			return temp->next;
		else 
			return NULL;
	}
	else
		return NULL;
}

void add(ListPointer* list, int value)
{
	ListElement *newElement = new ListElement;
	if (list->head == NULL)
	{
	    newElement->next = NULL;
	    newElement->value = value;
	    list->head = newElement;
	}
	else
	{
		newElement->next = list->head;
		newElement->value = value;
        list->head = newElement;
    }	
}

void deleteList(ListPointer *list)
{
	ListElement *temp = list->head;
	while (temp != NULL)
	{
		list->head = list->head->next;
		delete temp;
		temp = list->head;
	}
	delete list;
}

int retrieve(Position pos, ListPointer *list)
{
	return pos->value;
}

void printEl(ListPointer *list)
{
	ListElement *constHead = list->head;
	while (constHead != NULL)
	{
		printf("%d ", constHead->value);
		constHead = constHead->next;
	}
}

void read(FILE *file, ListPointer *list)
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

int lengthOfList(ListPointer* list)
{
	int length = 0;
	Position head = first(list);
	while (head != NULL)
	{
		head = head->next;
		length++;
	}
	return length;
}
