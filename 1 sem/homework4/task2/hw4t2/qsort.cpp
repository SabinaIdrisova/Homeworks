void qsort(int* a, int begin, int end)
{
	int i = begin;
	int j = end;
	int temp = 0;
	int x = (begin + end) / 2;
	do
	{
		while (a[i] < a[x])
			i++;
		while (a[x] < a[j]) 
			j--;
		if (i <= j) 
		{
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		i++;
		j--;
	} 
	while (i <= j);
	if (begin < j) 
		qsort(a, begin, j);
	if (i < end)
		qsort(a, i, end);
}