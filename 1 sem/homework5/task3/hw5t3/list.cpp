#include <stdio.h>
#include "list.h"

struct ListElement
{
	int value;
	ListElement *next;
};

struct List
{
	ListElement *head;
};

List *createList()
{
	List *result = new List;
	result->head = NULL;
	return result;
}

void deleteElement(ListElement *position, List *list)
{
	if (list->head != position)
	{
		ListElement *provisory = list->head;
		while (provisory->next != position)
			provisory = provisory->next;
		provisory->next = position->next;
		delete position;
	}

	else
	{
		bool ticket = false;
		if (list->head == list->head->next)
			ticket = true;
		ListElement *temp = list->head->next;
		while (temp->next != position)
			temp = temp->next;
		temp->next = list->head->next;
		delete position;
		list->head = temp->next;
		if (ticket)
			list->head = NULL;
	}
}

void print(List *list)
{
	if (list->head != NULL)
	{
		printf("%d ", list->head->value);
		ListElement *printElement = list->head->next;
		while (printElement != list->head)
		{
			printf("%d ", printElement->value);
			printElement = printElement->next;
		}
	}
	printf("\n");
}

void add(int value, List* list)
{
	if (list->head == NULL)
	{
		ListElement *newElement = new ListElement;
		newElement->next = newElement;
		newElement->value = value;
		list->head = newElement;
	}
	else
	{
		ListElement *newElement = new ListElement;
		ListElement *searchFirst = list->head->next;
		while (searchFirst->next != list->head)
			searchFirst = searchFirst->next;
		searchFirst->next = newElement;
		newElement->next = list->head;
		newElement->value = value;
		list->head = newElement;
	}
}

int length(List *list)
{
	int length = 1;
	if (list->head != NULL)
	{
		ListElement *prevElement = list->head;
		while (prevElement->next != list->head)
		{
			length++;
			prevElement = prevElement->next;
		}
		return length;
	}
	else
		return 0;
}

Position next(Position pos, List *list)
{
	if (list->head != NULL)
	{
		ListElement* temporary = list->head;
		while (temporary != pos && temporary != NULL)
			temporary = temporary->next;
        if (temporary != NULL)
			return temporary->next;
		else 
			return NULL;
	}
	else
		return NULL;
}

Position head(List *list)
{
	return list->head;
}