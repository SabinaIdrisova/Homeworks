#pragma once

struct ListElement;
struct List;

typedef ListElement *Position;

List *createList();

//�������� k-�� �������� � ������
void deleteElement(ListElement *position, List *list);

//������ ������
void print(List *list);

//���������� �������� � ������
void add(int value, List* list);

//���������� ���������
int length(List *list);

//������� ���������� ��������
Position next(Position pos, List *list);

//������� ������� ��������
Position head(List *list);