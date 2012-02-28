#pragma once

struct ListElement;
struct ListPointer;

typedef ListElement *Position;

ListPointer *createList();

//Позиция первого элемента
Position first(ListPointer *list);

//Позиция следующего элемента
Position next(Position pos, ListPointer *list);

//Добавление элемента
void add(ListPointer *list, int value);

//Печать элементов
void printEl(ListPointer *list);

//Чтение из файла
void read(FILE *file, ListPointer *list);

//Удаление списка
void deleteList(ListPointer *list);

//Получение элемента по позиции
int retrieve(Position pos, ListPointer *list);

//Длина списка
int lengthOfList(ListPointer* list);