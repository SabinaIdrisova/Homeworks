#pragma once;

typedef struct Stack* pst;
struct Stack;

void push(pst &head, int a); //добавление элемента в конец
void pop(pst &head); //удаление последнего элемента
int front(Stack *pst); //возвращение последнего добавленного элемента
void deleteStack(pst &head); //очищение памяти
