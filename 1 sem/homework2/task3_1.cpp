#include <stdio.h>

int main()
{   int const size = 10;
    int a[size];
	int tmp = 0;  
	for (int i = 0; i < size; i++)
		scanf("%d", &a[i]);
	for (int i = 0; i < size; i++)
	{
        for (int j = 0; j < (size-i); j++) 
        {
            if (a[j+1] > a[j]) 
			{
                tmp = a[j]; 
                a[j] = a[j+1];
                a[j+1] = tmp;
            }
        }
    }
	for (int i = 0; i < size; i++) 
		printf("%d ", a[i]);
	return 0;
}