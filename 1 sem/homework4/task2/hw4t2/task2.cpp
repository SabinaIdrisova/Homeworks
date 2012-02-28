#include <stdio.h>
#include "qsort.h"

int main() 
{
	FILE* f = fopen("array.txt", "r");
	int const size = 10;
	int a[size];
	for (int i = 0; i < size; i++)
		fscanf(f, "%d", &a[i]);
    qsort(a, 0, size - 1);
	fclose(f);
	int length = 1;
	int maxLength = 1;
	for (int i = 0; i < size - 1; i++)
		if (a[i] == a[i + 1])
			length++;
		else
		{
			if (length > maxLength)
				maxLength = length;
			length = 1;
		}
		if (length > maxLength)
			maxLength = length;
		length = 1;
    for (int i = 0; i < size - 1; i++)
		if (a[i] == a[i + 1])
		    length++;
		else 
		{
			if (length == maxLength)
				printf("%d ", a[i]);
			length = 1;
		}
     if (length == maxLength)
		 printf("%d", a[size - 1]);
    return 0;
}
