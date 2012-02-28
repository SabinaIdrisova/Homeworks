# pragma once

typedef struct Node* pnode;
struct Node;
void addValue(pnode &root, int x); //добавить значение в сортированный список
void deleteValue(pnode &root, int x); //удалить значение из списка
void printList(pnode root); //распечатать список
void exit(pnode &root); //выйти


