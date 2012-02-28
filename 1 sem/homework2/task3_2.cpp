#include <stdio.h>

int main()
{
	int a[10];
	int b[10000];
	printf("vvedite elementi massiva\n");
	for (int i = 0; i < 10; i++)
		scanf("%d", &a[i]);
	for (int i = 0; i < 10000; i++)
		b[i] = 0;
	for (int i = 0; i < 10; i++)
		b[a[i]]++;
	for (int i = 0; i < 10000; i++)
		for (int j = 0; j < b[i]; j++)
			printf("%d ", i);
}
