#include <stdio.h>

void move(int *a, int l, int r)
{ 
	int tmp = 0;
	for (int i = l; i <= (l + r) / 2; i++)
	{
		tmp = a[i];
		a[i] = a[l + r - i];
		a[l + r - i] = tmp;
	}
}

int main()
{
	int const m = 2, n = 5;
	int x[m + n + 1];
	for (int i = 1; i <= m + n; i++)
	{
		scanf("%d", &x[i]);
	}
	move(x, 1, m);
	move(x, m + 1, m + n);
	move(x, 1, m + n);
	for (int i = 1; i <= m + n; i++)
	{
		printf("%d ", x[i]);
	}
	return 0;
}