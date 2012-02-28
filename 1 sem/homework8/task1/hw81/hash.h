#pragma once

struct Hash;

Hash *createHash();

//хеширование
int hash1(char word[]);

//поиск слова 
bool findWord(Hash *hash, char word[]);

//добавление элемента
void add(Hash *hash, char word[]);

//вывод результата
void print(Hash *hash);
