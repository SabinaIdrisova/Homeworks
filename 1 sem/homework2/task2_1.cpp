#include <stdio.h>

int main()
{
    int n = 0;
	int a = 0;
	printf("vvedite osnovanie stepeni a i pokazatel stepeni n\n");
	scanf("%d%d", &a, &n);
	int result = 1;
	for (int i = 0; i < n; i++)
	{
		result *= a;
	}
	printf("a^n = %d\n", result);
	return 0;
}
