#pragma once

typedef struct Stack* pst;
struct Stack;

void push(pst &head, int a); //добавление элемента
void pop(pst &head); //удаление последнего элемента
int front(Stack *pst); //возвращение последнего элемента

