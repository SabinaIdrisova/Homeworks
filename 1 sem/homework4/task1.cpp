#include <stdio.h>
#include <locale.h>

int const size = sizeof(int) * 8;

int from10To2(int *array, int number)
{
	int mask = 1;
	for (int i = 0; i < size; i++) 
    {
		if ((mask & number) == 0)
			array[i] = 0;
		else
			array[i] = 1;
		mask = mask << 1;
	}
	for (int i = size - 1; i >=0; i--)
		printf("%d",array[i]);
	printf("\n");
    return 0;
}

int from2To10(int *array, int number)
{
	int degree2 = 1;
	for (int i = 0; i < size; i++)
	{
		number += array[i] * degree2;
		degree2 *= 2;
	}
	return number;
}

int sumIn2(int *num1, int *num2, int *sum)
{
	int mind = 0;
	for (int i = 0; i < size; i++)
	{
		if (num1[i] + num2[i] == 0)
			if (mind == 0)
				sum[i] = 0;
			else 
			{
			    sum[i] = 1;
				mind = 0;
			}
		if (num1[i] + num2[i] == 1)
			if (mind == 0)
				sum[i] = 1;
			else
			{
				sum[i] = 0;
				mind = 1;
			}
		if (num1[i] + num2[i] == 2)
			if (mind == 0)
			{
				sum[i] = 0;
				mind = 1;
			}
			else
			{
				sum[i] = 1;
				mind = 1;
			}
	}
	printf("сумма в двоичном виде: ");
    for (int i = size - 1; i >= 0; i--)
	    printf("%d", sum[i]);
	printf("\n");
	return 0;
}

int main()
{
	setlocale(LC_ALL, "Rus");
	int bin1[size];
	int bin2[size];
	int number1 = 0;
	int number2 = 0;
	printf("введите 2 числа\n");
	scanf("%d%d", &number1, &number2);
    from10To2(bin1, number1);
	from10To2(bin2, number2);
	int sum[size];
	sumIn2(bin1, bin2, sum);
	int number3 = 0;
	printf("сумма в десятичном виде: %d\n", from2To10(sum, number3));
    return 0;
}
