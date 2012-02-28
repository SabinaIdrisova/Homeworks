#pragma once

struct ListArray;

typedef int Position;

ListArray *createList();

//������� ������� ��������
Position first(ListArray *list);

//������� ���������� ��������
Position next(int position, ListArray *list);

//���������� ��������
void add(ListArray *list, int value);

//������ ���������
void printEl(ListArray *list);

//������ �� �����
void read(FILE *file, ListArray *list);

//�������� ������
void deleteList(ListArray *list);

//��������� �������� �� �������
int retrieve(int position, ListArray *list);

//����� ������
int lengthOfList(ListArray* list);
