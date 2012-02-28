#include <stdio.h>

int main()

{
	int const dimension = 28, lim = 10;
	int sum[dimension], i, j, k;
	for (i = 0; i < dimension; i++)
		sum[i] = 0;
	for (i = 0; i < lim; i++)
		for (j = 0; j < lim; j++)
			for (k = 0; k < lim; k++)
			{
				sum[i + j + k]++;
			}
	int amount = 0;
	for (i = 0; i < dimension; i++)
	{
		sum[i] *= sum[i];
		amount += sum[i];
	}
    printf("%d\n", amount);
	return(0);
}
