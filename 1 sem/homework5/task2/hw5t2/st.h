# pragma once

typedef struct Node* pnode;
struct Node;
void addValue(pnode &root, int x); //�������� �������� � ������������� ������
void deleteValue(pnode &root, int x); //������� �������� �� ������
void printList(pnode root); //����������� ������
void exit(pnode &root); //�����


