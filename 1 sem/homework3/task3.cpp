#include <stdio.h>
#include <algorithm>

using namespace std;

void qsort(int* a, int begin, int end)
{
	int i = begin;
	int j = end;
	int x = (begin + end) / 2;
	do
	{
		while (a[i] < a[x])
			i++;
		while (a[x] < a[j]) 
			j--;
		if (i <= j) 
			swap(a[i++], a[j--]);
	} 
	while (i <= j);
	if (begin < j) 
		qsort(a, begin, j);
	if (i < end)
		qsort(a, i, end);
}

int main() 
{
	int const size = 10;
	int a[size];
	printf("vvedite elementi massiva\n");
	for (int i = 0; i < size; i++) 
		scanf("%d", &a[i]);
	qsort(a, 0, size - 1);
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
		 printf("%d", a[size-1]);
    return 0;
}
