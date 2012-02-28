#include <stdio.h>                                                                    

int main()
{
	int number = 0;
	scanf("%d", &number);
	for (int i = 2; i <= number; i++)
	{
		int j = 1;
		do
		{
			j++;
		}
	    while (i % j != 0);
	    if (i == j)
		{
		    printf("%d\n", i);
		}
	}
	return 0;
}
