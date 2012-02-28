#include <stdio.h>

int main()
{   
	int x, y;
	scanf("%d", &x);
	y = x * x;
	y = (y + x) * (y + 1);
	printf("%d\n", y);
	return 0; 
}