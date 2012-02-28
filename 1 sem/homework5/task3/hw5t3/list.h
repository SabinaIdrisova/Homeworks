#pragma once

struct ListElement;
struct List;

typedef ListElement *Position;

List *createList();

//удаление k-го элемента в списке
void deleteElement(ListElement *position, List *list);

//печать списка
void print(List *list);

//добавление элемента в список
void add(int value, List* list);

//количество элементов
int length(List *list);

//позиция следующего элемента
Position next(Position pos, List *list);

//позиция первого элемента
Position head(List *list);