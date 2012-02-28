#include <cstdio>
#include <cstdlib>
#include <ctime>
#include <algorithm>

using namespace std;

int const maxN = 10000;

void qsort(int* a, int left, int right)
{
    int i = left;
	int j = right;
	int mid = (left + right) / 2;
	do
	{
		while (a[i] < a[mid])
			i++;
		while (a[mid] < a[j])
			j--;
		if (i <= j) 
			swap(a[i++], a[j--]);
	} 
	while (i <= j);
	if (left < j)
	    qsort(a, left, j);
	if (i < right) 
	    qsort(a, i, right);
}

int binSearch(int *a, int number, int n) 
{
	int left = 0;
    int right = n - 1;
	while (left < right) 
	{
		int mid = (left + right) / 2;
		if (a[mid] < number)
	        left = mid + 1;
        else 
			right = mid;
		
	}
	if (a[left] != number) 
		return -1;
	else 
		return left;
	
}

int main() 
{
	int n = 0;
	int a[maxN];
	int k = 0;
	printf("vvedite n (1 <= n <= 5000) i k (1 <= k <= 300000)\n");
	scanf("%d%d", &n, &k);
	srand(time(NULL));
	for (int i = 0; i < n; i++)
		a[i] = rand() % 1000;
	for (int i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
	qsort(a, 0, n - 1);
	for (int i = 0; i < n; i++)
		printf("%d ", a[i]);
	for (int i = 0; i < k; i++) 
	{
		int k = 0;
		scanf("%d", &k);
		printf("%d\n", binSearch(a, k, n)); 
	}
	return 0;
}