#include <stdio.h>
int main ()

{
	int a[10], i, count = 0;
	int const dimension = 10;
	for (i = 0; i < dimension; i++)
	{ 
		scanf("%d", &a[i]);
	}
	for (i = 0; i < dimension; i++)
	{
		if (a[i] == 0)
			count++;
	}
	printf("%d", count);
	return(0);
}

