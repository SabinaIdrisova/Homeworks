#pragma once

typedef struct Stack* pst;
struct Stack;

void push(pst &head, int a); //���������� ��������
void pop(pst &head); //�������� ���������� ��������
int front(Stack *pst); //����������� ���������� ��������

