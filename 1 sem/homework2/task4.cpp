#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{   
	int const size = 10;
	int a[size];
	srand(time(NULL));
    for (int i = 1; i <= size; i++)
		a[i] = rand() % 100;
	int j = 1;
	int k = size;
	int t = a[1];
	do
	{
		while ((a[j] <= t) && (j < k))
			j++;
		while ((a[k] > t) && (j <= k))
			k--;
		if (j <= k)
		{
		    int x = a[j];
			a[j] = a[k];
			a[k] = x;
        }
    }
	while (j <= k);
	for (int i = 1; i <= size; i++)
		printf("%d ", a[i]);
	return 0;
}