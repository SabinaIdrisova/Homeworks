#pragma once;

struct Phone;

void addContact(char name[], int number, Phone *&list); //���������� ������
void searchByName(char name[], Phone *list); //����� ������ �� �����
void searchByNumber(int number, Phone *list); //����� ����� �� ������
void save(Phone *list); //���������� ������� ������ � ����
void exit(Phone *list); //�����
void open(Phone *&list); //�������� �����

