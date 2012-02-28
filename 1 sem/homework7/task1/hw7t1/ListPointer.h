#pragma once

struct ListElement;
struct ListPointer;

typedef ListElement *Position;

ListPointer *createList();

//������� ������� ��������
Position first(ListPointer *list);

//������� ���������� ��������
Position next(Position pos, ListPointer *list);

//���������� ��������
void add(ListPointer *list, int value);

//������ ���������
void printEl(ListPointer *list);

//������ �� �����
void read(FILE *file, ListPointer *list);

//�������� ������
void deleteList(ListPointer *list);

//��������� �������� �� �������
int retrieve(Position pos, ListPointer *list);

//����� ������
int lengthOfList(ListPointer* list);