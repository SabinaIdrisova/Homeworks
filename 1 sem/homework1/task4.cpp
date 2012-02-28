#include "stdio.h"
#include <cstdlib>

int main()
{
	int a, b;
	scanf("%d%d", &a, &b);
	bool sign = true;
	if (b == 0)
		printf("vypolnenie operacii nevozmozhno\n");
	else
    {
	    if (a * b < 0)
		    sign = false;
	    a = abs(a);
	    b = abs(b);
	    int dif = a, count = 0;
	    do 
	    {
		    dif -= b;
            count++;
	    }
	    while (dif >= 0);
	    count--;
	    if (!sign)
	        count = -count;
	    printf("%d\n", count);
	}
	return 0;
}