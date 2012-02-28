#include <stdio.h>
#include <algorithm>
#include <time.h>

using namespace std;

void insert (int*a, int n, int l)
{
	for (int i = n + 1; i < l; i++)
		for (int j = i; j > 0; j--)
			if (a[j-1] > a[j])
				swap (a[j-1], a[j]);
}

void qsort(int* a, int begin, int end)
{
	if (end - begin < 10) 
	{
        insert(a, begin, end);
        return;
    }
	int j = begin;
	int k = end;
	int x = (begin + end) / 2;
	do
	{
		while (a[j] < a[x])
			j++;
		while (a[x] < a[k])
			k--;
		if (j <= k) 
			swap(a[j++], a[k--]);
	} 
	while (j <= k);
	if (begin < k) qsort(a, begin, k);
	if (j < end) qsort(a, j, end);
}

int main() 
{
	int const size = 10000;
	int a[size];
	srand(time(NULL));
    for (int i = 0; i < size; i++)
		a[i] = rand() % 100;
	qsort(a, 0, size - 1);
	for (int i = 0; i < size; ++i) 
		printf("%d ", a[i]);
	printf("\n");
	return 0;
}