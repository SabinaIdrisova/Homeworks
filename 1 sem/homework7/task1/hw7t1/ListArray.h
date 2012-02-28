#pragma once

struct ListArray;

typedef int Position;

ListArray *createList();

//Позиция первого элемента
Position first(ListArray *list);

//Позиция следующего элемента
Position next(int position, ListArray *list);

//Добавление элемента
void add(ListArray *list, int value);

//Печать элементов
void printEl(ListArray *list);

//Чтение из файла
void read(FILE *file, ListArray *list);

//Удаление списка
void deleteList(ListArray *list);

//Получение элемента по позиции
int retrieve(int position, ListArray *list);

//Длина списка
int lengthOfList(ListArray* list);
