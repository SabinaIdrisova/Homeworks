#pragma once;

struct Phone;

void addContact(char name[], int number, Phone *&list); //Добавление записи
void searchByName(char name[], Phone *list); //Поиск номера по имени
void searchByNumber(int number, Phone *list); //Поиск имени по номеру
void save(Phone *list); //Сохранение текущих данных в файл
void exit(Phone *list); //Выход
void open(Phone *&list); //Открытие файла

