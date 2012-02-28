#include <stdio.h>
#include <string.h>
#include <locale.h>

void prefix(char* substring, int* pi)
{
	for (int i = 1,  j = 0; i < strlen(substring); i++)
    {
		pi[0] = 0;
        while (j > 0 && substring[j] != substring[i])
			j = pi[j - 1];
        if(substring[j] == substring[i])
            j++;
        pi[i] = j;
     }
}

int search(char* string, char* substring)
{
	int *pi = new int[strlen(substring)];
	prefix(substring, pi);
    for (int i = 0, j = 0; i < strlen(string); i++)
    {
        while( j > 0 && substring[j] != string[i])
            j = pi[j - 1];
        if (substring[j] == string[i]) 
            j++;
        if (j == strlen(substring))
        {
             delete pi;
             return i - j + 2;
        }
    }
    delete pi;
    return -1;
}

int main()
{
	setlocale(LC_ALL, "Rus");
	FILE *file = fopen("test.txt", "r");
	char string[40];
	fscanf(file, "%s", string);
	fclose(file);
	printf("Введите подстроку, которую нужно найти\n");
    char substring[40];
	scanf("%s", substring);
	int position = search(string, substring);
	if (position == -1)
		printf("Подстрока не встречается в исходной строке\n");
	else
		printf("Первое вхождение подстроки в строке: %d\n", position);
	return 0;
}